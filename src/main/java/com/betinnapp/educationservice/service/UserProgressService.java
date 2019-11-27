package com.betinnapp.educationservice.service;

import com.betinnapp.educationservice.model.Module;
import com.betinnapp.educationservice.model.Submodule;
import com.betinnapp.educationservice.model.User;
import com.betinnapp.educationservice.model.UserProgress;
import com.betinnapp.educationservice.model.type.ModuleType;
import com.betinnapp.educationservice.model.type.StatusType;
import com.betinnapp.educationservice.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserProgressService {

    @Autowired
    private UserProgressRepository userProgressRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private CoinService coinService;

    public void generateFirstProgressByToken(UUID userToken) {
        User user = userService.findUserByToken(userToken);
        int steps = user.getInitialScore().intValue() / 2;
        List<Module> modules = moduleService.findAll();

        if (steps == 0)
            steps=1;

        for (int x = 0; x < steps; x++) {
            unlockNextModule(user, modules);
        }
    }

    public void unlockNextModuleByToken(UUID token) {
        User user = userService.findUserByToken(token);
        List<Module> modules = moduleService.listModulesByToken(token);

        unlockNextModule(user, modules);
    }

    private Boolean unlockNextModule(User user, List<Module> modules) {
        Boolean modify = false;

        for (Module m : modules) {

            if (m.getStatus() == StatusType.LOCKED) {
                m.setStatus(StatusType.UNLOCKED);
                createUserProgress(user.getId(), m.getId(), ModuleType.MODULE, StatusType.UNLOCKED);
                Submodule submodule = m.getSubmodule().iterator().next();
                submodule.setStatus(StatusType.UNLOCKED);
                createUserProgress(user.getId(), submodule.getId(), ModuleType.SUBMODULE, StatusType.UNLOCKED);
                break;
            }

            for (Submodule s : m.getSubmodule()) {

                if (s.getStatus() == StatusType.LOCKED) {
                    s.setStatus(StatusType.UNLOCKED);
                    createUserProgress(user.getId(), s.getId(), ModuleType.SUBMODULE, StatusType.UNLOCKED);
                    modify = true;
                    break;
                }
            }
            if (modify) {
                modify = false;
                break;
            }
        }
        return modify;
    }

    public void createUserProgress(UUID userId, UUID moduleId, ModuleType moduleType, StatusType statusType) {
        UserProgress userProgress = new UserProgress();

        userProgress.setUserId(userId);
        userProgress.setModuleID(moduleId);
        userProgress.setModuleType(moduleType);
        userProgress.setStatusType(statusType);

        userProgressRepository.save(userProgress);
    }

    public HashMap<UUID, StatusType> getUserProgressByToken(UUID token) {

        HashMap<UUID, StatusType> userProgress = new HashMap<>();
        UUID userId = userService.findUserIdByToken(token);
        List<UserProgress> progress = userProgressRepository.findByUserId(userId);

        for (UserProgress p : progress) {
            userProgress.put(p.getModuleID(), p.getStatusType());
        }

        return userProgress;
    }

    public void completeSubmodule(UUID submoduleID, UUID moduleID, UUID userToken) {

        UUID userID = userService.findUserIdByToken(userToken);
        UserProgress userProgress = userProgressRepository.findByModuleIDAndUserId(submoduleID, userID);
        userProgress.setStatusType(StatusType.COMPLETED);
        userProgressRepository.save(userProgress);

        verifyModuleCompletition(moduleID, userToken);
        verifySubmoduleUnlock(moduleID, userToken);

        coinService.addCoin(userID, 1);
    }

    public void verifyModuleCompletition(UUID moduleID, UUID userToken) {
        List<Module> userModules = moduleService.listModulesByToken(userToken);
        UUID userID = userService.findUserIdByToken(userToken);
        Boolean completed = true;
        for (Module m : userModules) {
            if (m.getId().equals(moduleID)) {
                for (Submodule s : m.getSubmodule()) {
                    if (s.getStatus() != StatusType.COMPLETED) {
                        completed = false;
                    }
                }

                if (completed) {
                    UserProgress userProgress = userProgressRepository.findByModuleIDAndUserId(m.getId(), userID);
                    userProgress.setStatusType(StatusType.COMPLETED);
                    userProgressRepository.save(userProgress);

                    unlockNextModuleByToken(userToken);
                }
                break;
            }
        }
    }

    public void verifySubmoduleUnlock(UUID moduleID, UUID userToken) {
        List<Module> userModules = moduleService.listModulesByToken(userToken);
        UUID userID = userService.findUserIdByToken(userToken);

        for (Module m : userModules) {
            if (m.getId().equals(moduleID)) {
                for (Submodule s : m.getSubmodule()) {
                    if (s.getStatus() == StatusType.LOCKED) {
                        createUserProgress(userID, s.getId(), ModuleType.SUBMODULE, StatusType.UNLOCKED);

                        break;
                    }
                }
            }
        }
    }
}

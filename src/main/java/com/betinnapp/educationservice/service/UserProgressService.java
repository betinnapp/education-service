package com.betinnapp.educationservice.service;

import com.betinnapp.educationservice.model.UserProgress;
import com.betinnapp.educationservice.model.type.StatusType;
import com.betinnapp.educationservice.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserProgressService {

    @Autowired
    private UserProgressRepository userProgressRepository;

    @Autowired
    private UserService userService;

    public HashMap<UUID, StatusType> getUserProgressByToken(UUID token) {

        HashMap<UUID, StatusType> userProgress = new HashMap<>();
        UUID userId = userService.findUserIdByToken(token);
        List<UserProgress> progress = userProgressRepository.findByUserId(userId);

        for (UserProgress p : progress) {
            userProgress.put(p.getModuleID(), p.getStatusType());
        }

        return userProgress;
    }

}

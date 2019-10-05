package com.betinnapp.educationservice.service;

import com.betinnapp.educationservice.model.Module;
import com.betinnapp.educationservice.model.Submodule;
import com.betinnapp.educationservice.model.type.StatusType;
import com.betinnapp.educationservice.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private UserProgressService userProgressService;

    public List<Module> listModulesByToken(UUID token) {

        List<Module> modules = moduleRepository.findAll();
        HashMap<UUID, StatusType> userProgress = userProgressService.getUserProgressByToken(token);

        if (userProgress != null && userProgress.isEmpty())
            userProgressService.generateFirstProgressByToken(token);

        return getModuleProgression(modules, userProgress);
    }

    public Module getModule(UUID moduleId, UUID token) {
        Module module = moduleRepository.findByIdOrderByModuleOrder(moduleId).orElse(null);
        HashMap<UUID, StatusType> userProgress = userProgressService.getUserProgressByToken(token);
        return getModuleProgression(Collections.singletonList(module),userProgress).get(0);
    }

    private List<Module> getModuleProgression(List<Module> modules, HashMap<UUID, StatusType> userProgress) {
        for (Module m : modules) {
            if (userProgress.containsKey(m.getId())) {
                m.setStatus(userProgress.get(m.getId()));

                for (Submodule s : m.getSubmodule()) {
                    if (userProgress.containsKey(s.getId())) {
                        s.setStatus(userProgress.get(s.getId()));
                    }
                }
            }
        }

        return modules;
    }

    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    public void save(Module module) {
        moduleRepository.save(module);
    }
}

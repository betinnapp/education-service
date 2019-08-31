package com.betinnapp.educationservice.service;

import com.betinnapp.educationservice.model.Module;
import com.betinnapp.educationservice.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> listModules(){
        return moduleRepository.findAll();
    }


}

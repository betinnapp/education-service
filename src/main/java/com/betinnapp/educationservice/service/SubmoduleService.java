package com.betinnapp.educationservice.service;

import com.betinnapp.educationservice.exception.NotFoundException;
import com.betinnapp.educationservice.model.Submodule;
import com.betinnapp.educationservice.repository.SubmoduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubmoduleService {

    @Autowired
    private SubmoduleRepository submoduleRepository;

    public Submodule getSubmoduleByModuleIdAndSubmoduleId(UUID submoduleId) throws NotFoundException {
        try {

            return submoduleRepository.findById(submoduleId).get();
        }catch (Exception e){
            throw new NotFoundException("SUBMODULE_NOT_FOUND");
        }
    }

}

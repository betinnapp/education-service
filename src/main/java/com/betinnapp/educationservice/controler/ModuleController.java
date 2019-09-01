package com.betinnapp.educationservice.controler;

import com.betinnapp.educationservice.exception.InvalidTokenException;
import com.betinnapp.educationservice.exception.NotFoundException;
import com.betinnapp.educationservice.model.Submodule;
import com.betinnapp.educationservice.model.dto.AuthTokenDTO;
import com.betinnapp.educationservice.service.ModuleService;
import com.betinnapp.educationservice.service.SubmoduleService;
import com.betinnapp.educationservice.service.UserProgressService;
import com.betinnapp.educationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.betinnapp.educationservice.model.Module;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path = "module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private SubmoduleService submoduleService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserProgressService userProgressService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/list")
    public List<Module> listModules(@RequestBody AuthTokenDTO token) throws InvalidTokenException {

        userService.tokenIsValid(token.get());
        return moduleService.listModulesByToken(token.get());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/{moduleId}/submodule/{submoduleId}")
    public Submodule getSubmodule(@PathVariable("submoduleId") String submoduleId, @RequestBody AuthTokenDTO token) throws InvalidTokenException, NotFoundException {

        userService.tokenIsValid(token.get());
        return submoduleService.getSubmoduleByModuleIdAndSubmoduleId(UUID.fromString(submoduleId));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(path = "/{moduleId}/submodule/{submoduleId}/completed")
    public void completeSubmodule(@PathVariable("submoduleId") String submoduleId, @PathVariable("moduleId") String moduleId, @RequestBody AuthTokenDTO token) throws InvalidTokenException, NotFoundException {

        userService.tokenIsValid(token.get());
        userProgressService.completeSubmodule(UUID.fromString(submoduleId), UUID.fromString(moduleId), token.get());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(path = "/unlock/next")
    public void unlockModule(@RequestBody AuthTokenDTO token) throws InvalidTokenException {

        userService.tokenIsValid(token.get());
        userProgressService.unlockNextModuleByToken(token.get());
    }

}

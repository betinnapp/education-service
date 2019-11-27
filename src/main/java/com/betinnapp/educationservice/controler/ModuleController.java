package com.betinnapp.educationservice.controler;

import com.betinnapp.educationservice.exception.InvalidTokenException;
import com.betinnapp.educationservice.exception.NotFoundException;
import com.betinnapp.educationservice.model.Coin;
import com.betinnapp.educationservice.model.Submodule;
import com.betinnapp.educationservice.service.*;
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

    @Autowired
    private CoinService coinService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/list")
    public List<Module> listModules(@RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {
        UUID authToken =  UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return moduleService.listModulesByToken(authToken);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/{moduleId}/submodule/{submoduleId}")
    public Submodule getSubmodule(@PathVariable("submoduleId") String submoduleId, @RequestHeader(name = "authorization") String authorization) throws InvalidTokenException, NotFoundException {
        UUID authToken =  UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return submoduleService.getSubmoduleByModuleIdAndSubmoduleId(UUID.fromString(submoduleId));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/{moduleId}")
    public Module getModule(@PathVariable("moduleId") String moduleId, @RequestHeader(name = "authorization") String authorization) throws InvalidTokenException, NotFoundException {
        UUID authToken =  UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return moduleService.getModule(UUID.fromString(moduleId),authToken);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(path = "/{moduleId}/submodule/{submoduleId}/completed")
    public void completeSubmodule(@PathVariable("submoduleId") String submoduleId, @PathVariable("moduleId") String moduleId, @RequestHeader(name = "authorization") String authorization) throws InvalidTokenException, NotFoundException {

        UUID authToken =  UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        userProgressService.completeSubmodule(UUID.fromString(submoduleId), UUID.fromString(moduleId), authToken);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(path = "/unlock/next")
    public void unlockModule(@RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {

        UUID authToken =  UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        userProgressService.unlockNextModuleByToken(authToken);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/quick-access")
    public List<Module> quickAcess(@RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {

        UUID authToken =  UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return moduleService.getQuickAcess(authToken);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/coin")
    public Coin getCoin(@RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {
        UUID authToken =  UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return coinService.getCoinByToken(authToken);
    }

}

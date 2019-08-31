package com.betinnapp.educationservice.controler;

import com.betinnapp.educationservice.model.dto.AuthTokenDTO;
import com.betinnapp.educationservice.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.betinnapp.educationservice.model.Module;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping(path = "/list")
    public List<Module> listModules(@RequestBody AuthTokenDTO token) {
        return moduleService.listModulesByToken(token.get());
    }
}

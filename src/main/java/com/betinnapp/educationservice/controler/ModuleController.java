package com.betinnapp.educationservice.controler;


import com.betinnapp.educationservice.model.Submodule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.betinnapp.educationservice.model.Module;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "module")
public class ModuleController {

    @GetMapping(path = "/list")
    public List<Module> listModules(){
        List<Module> modules = new ArrayList<>();
        Module module = new Module();

        List<Submodule> submodules = new ArrayList<>();
        Submodule submodule = new Submodule();

        submodules.add(submodule);
        submodules.add(submodule);

        module.setSubmodule(submodules);

        modules.add(module);
        modules.add(module);

        return modules;
    }


}

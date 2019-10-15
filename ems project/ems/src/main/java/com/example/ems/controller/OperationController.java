package com.example.ems.controller;


import com.example.ems.model.Operation;

import com.example.ems.service.OperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ops")
public class OperationController {
    @Autowired
    OperationService operationService;

//    @PostMapping(path="/operation")
//    public Operation addOperation(@RequestBody Operation operation)
//    {
//        return operationService.save(operation);
//
//    }
//    @GetMapping(path="/projects")
//    public List<Project> getProjects()
//    {
//        return projectService.getProjects();
//
//
//    }
//    @RequestMapping("/employee/{eid}")
//    public Optional<Project> getProject(@PathVariable("pid")int pid)
//    {
//        return projectService.getProjectById(pid);
//
//
//    }

    @GetMapping(path="/projects")
    public List<Operation> getOperationById(@PathVariable int oid)
    {
        return operationService.getOperationById(oid);
    }
}

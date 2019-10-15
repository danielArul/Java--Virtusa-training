package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.model.Project;
import com.example.ems.service.EmployeeService;
import com.example.ems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/proj")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping(path="/project")
    public Project addProject(@RequestBody Project project)
    {
        return projectService.save(project);

    }
    @GetMapping(path="/projects")
    public List<Project> getProjects()
    {
        return projectService.getProjects();


    }
    @RequestMapping("/employee/{eid}")
    public Optional<Project> getProject(@PathVariable("pid")int pid)
    {
        return projectService.getProjectById(pid);


    }
}

package com.steffan.projectService.controller;

import com.steffan.projectService.model.Project;
import com.steffan.projectService.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/ems/projects")
    public List<Project> allProjects(){
        return projectService.getAllProjects();
    }

    @PreAuthorize("hasRoles(ROLE_MANAGER)")
    @RequestMapping(value="/ems/projects", method= RequestMethod.POST )
    public void addProject(@RequestBody Project project){
        projectService.addProject(project);

    }

    @RequestMapping("/ems/employee/projects/{eid}")
    public List<Project> getEmpProjects(@PathVariable Integer eid){
        return projectService.getEmpProjects(eid);
    }


}

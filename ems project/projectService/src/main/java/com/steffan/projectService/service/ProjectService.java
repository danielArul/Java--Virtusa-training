package com.steffan.projectService.service;

import com.steffan.projectService.model.Project;
import com.steffan.projectService.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo projectRepo;

    public List<Project> getAllProjects(){
        List<Project> projects=new ArrayList<>();

        for(Project e:projectRepo.findAll()){
            projects.add(e);
        }
        return projects;
    }

    public void addProject(Project project){
        projectRepo.save(project);
    }



}

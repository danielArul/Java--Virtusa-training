package com.example.ems.service;

import com.example.ems.model.Employee;
import com.example.ems.model.Project;
import com.example.ems.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getProjects() {

        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(int id) {

        return projectRepository.findById(id);
    }

    public void deleteProjectById(int id){
        projectRepository.deleteById(id);
    }

}

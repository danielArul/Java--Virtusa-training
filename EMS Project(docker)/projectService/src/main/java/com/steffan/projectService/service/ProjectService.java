package com.steffan.projectService.service;

import com.steffan.projectService.config.GetToken;
import com.steffan.projectService.model.Project;
import com.steffan.projectService.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Project> getEmpProjects(Integer pid){
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer "+ GetToken.getToken());
        HttpEntity<String> request=new HttpEntity<>(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Integer>> response=restTemplate.exchange("http://localhost:8089/ems/employee/project/" + pid, HttpMethod.GET, request, new ParameterizedTypeReference<List<Integer>>() {
        });
        List<Integer> pids=response.getBody();
        List<Project> projects=new ArrayList<>();
        pids=pids.stream().distinct().collect(Collectors.toList());

        for (Integer p:pids){
            projects.add(projectRepo.findById(p).get());
        }

        return projects;
    }


}

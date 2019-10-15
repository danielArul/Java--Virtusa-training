package com.example.emsui2.service;

import com.example.emsui2.config.GetToken;
import com.example.emsui2.model.Employee;
import com.example.emsui2.model.Project;
import com.example.emsui2.model.Task;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UIservice {

    public List<Employee> allEmployees(){
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer "+ GetToken.getToken());
        HttpEntity request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Employee>> response=restTemplate.exchange("http://localhost:8089/ems/employees", HttpMethod.GET, request, new ParameterizedTypeReference<List<Employee>>() {
        });


        List<Employee> employees=new ArrayList<>();
        employees=response.getBody();

        return employees;


    }

    public List<Project> allProjects(){
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer "+ GetToken.getToken());
        HttpEntity request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Project>> response=restTemplate.exchange("http://localhost:8084/ems/projects", HttpMethod.GET, request, new ParameterizedTypeReference<List<Project>>() {
        });


        List<Project> projects=new ArrayList<>();
        projects=response.getBody();

        return projects;


    }


    public List<Task> allTasks(){
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer "+ GetToken.getToken());
        HttpEntity request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Task>> response=restTemplate.exchange("http://localhost:8083/ems/tasks", HttpMethod.GET, request, new ParameterizedTypeReference<List<Task>>() {
        });


        List<Task> tasks=new ArrayList<>();
        tasks=response.getBody();

        return tasks;


    }
}

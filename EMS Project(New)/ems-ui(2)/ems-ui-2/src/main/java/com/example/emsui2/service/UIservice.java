package com.example.emsui2.service;

import com.example.emsui2.config.GetToken;
import com.example.emsui2.model.EPTdto;
import com.example.emsui2.model.Employee;
import com.example.emsui2.model.Project;
import com.example.emsui2.model.Task;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
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


    public String addEmployee(@ModelAttribute Employee employee){
        HttpHeaders header=new HttpHeaders();
        String token=GetToken.getToken();
        header.set("Authorization", "bearer"+token);

        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Employee> request=new HttpEntity<>(employee,header);
        restTemplate.postForEntity("http://localhost:8089/ems/employees",request,Employee.class);

        return "redirect:/employee";
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

    public String addProject(@ModelAttribute Project project){
        HttpHeaders header=new HttpHeaders();
        String token=GetToken.getToken();
        header.set("Authorization", "bearer"+token);

        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Project> request=new HttpEntity<>(project,header);
        restTemplate.postForEntity("http://localhost:8084/ems/projects",request,Project.class);

        return "redirect:/projects";
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

    public String addTask(@ModelAttribute Task task){
        HttpHeaders header=new HttpHeaders();
        String token=GetToken.getToken();
        header.set("Authorization", "bearer"+token);

        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Task> request=new HttpEntity<>(task,header);
        restTemplate.postForEntity("http://localhost:8083/ems/tasks",request,Task.class);

        return "redirect:/tasks";
    }


    public void addOperation(EPTdto epTdto){

        HttpHeaders header=new HttpHeaders();
        String token=GetToken.getToken();
        header.set("Authorization", "bearer"+token);

        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<EPTdto> request=new HttpEntity<>(epTdto,header);
        restTemplate.postForEntity("http://localhost:8089/ems/operation",request,EPTdto.class);



    }
}

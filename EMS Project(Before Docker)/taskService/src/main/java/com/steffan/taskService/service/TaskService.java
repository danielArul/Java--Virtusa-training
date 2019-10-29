package com.steffan.taskService.service;

import com.steffan.taskService.model.Task;
import com.steffan.taskService.repository.TaskRepo;
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
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    public List<Task> getAllTasks(){
        List<Task> tasks=new ArrayList<>();

        for(Task e:taskRepo.findAll()){
            tasks.add(e);
        }
        return tasks;
    }

    public void addTask(Task task){
        taskRepo.save(task);
    }

    public List<Task> getProjTasks(List<Integer> tids){
        tids=tids.stream().distinct().collect(Collectors.toList());
        List<Task> tasks=new ArrayList<>();
        for (int i:tids) {
            tasks.add(taskRepo.findById(i).get());
        }
        return tasks;
    }
}

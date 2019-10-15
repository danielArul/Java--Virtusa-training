package com.steffan.taskService.service;

import com.steffan.taskService.model.Task;
import com.steffan.taskService.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}

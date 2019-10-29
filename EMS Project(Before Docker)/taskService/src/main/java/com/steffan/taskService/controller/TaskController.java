package com.steffan.taskService.controller;


import com.steffan.taskService.model.Task;
import com.steffan.taskService.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;



    @RequestMapping("/ems/tasks")
    public List<Task> allTasks(){
        return taskService.getAllTasks();
    }

    @RequestMapping(value="/ems/tasks", method= RequestMethod.POST )
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);

    }

    @RequestMapping(value = "/ems/project/tasks", method=RequestMethod.POST)
    public List<Task> getTasksEmp(@RequestBody List<Integer> tids){//@RequestBody List<Integer> tids){
    //List<Integer> tids= Arrays.asList(1,2,3,4,5);
        System.out.println("tids");
        return taskService.getProjTasks(tids);
    }
}

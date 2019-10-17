package com.steffan.taskService.controller;


import com.steffan.taskService.model.Task;
import com.steffan.taskService.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/ems/project/tasks", method=RequestMethod.GET)
    public List<Task> getTasks(@RequestBody List<Integer> tids){
        System.out.println(tids);
        return taskService.getProjTasks(tids);
    }
}

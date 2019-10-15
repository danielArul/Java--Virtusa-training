package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.model.Project;
import com.example.ems.model.Task;
import com.example.ems.service.ProjectService;
import com.example.ems.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/tsk")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping(path="/task")
    public Task addTask(@RequestBody Task task)
    {
        return taskService.save(task);

    }
    @GetMapping(path="/tasks")
    public List<Task> getTasks()
    {
        return taskService.getTasks();


    }
    @RequestMapping("/task/{tid}")
    public Optional<Task> getTask(@PathVariable("tid")int tid)
    {
        return taskService.getTaskById(tid);


    }
}

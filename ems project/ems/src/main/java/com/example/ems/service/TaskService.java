package com.example.ems.service;

import com.example.ems.model.Project;
import com.example.ems.model.Task;
import com.example.ems.repository.ProjectRepo;
import com.example.ems.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepo taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {

        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(int id) {

        return taskRepository.findById(id);
    }

    public void deleteTaskById(int id){
        taskRepository.deleteById(id);
    }

}

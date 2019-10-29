package com.steffan.taskService.repository;

import com.steffan.taskService.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Task,Integer> {
}

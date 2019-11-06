package com.steffan.projectService.repository;

import com.steffan.projectService.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Integer> {
}

package com.example.ems.service;

import com.example.ems.model.Operation;
import com.example.ems.model.Project;
import com.example.ems.repository.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OperationService {

    @Autowired
    OperationRepo operationRepository;

//    public Operation save(Operation operation) {
//        return operationRepository.save(operation);
//    }
//
//    public List<Project> getProjects() {
//
//        return projectRepository.findAll();
//    }
//
//    public Optional<Project> getProjectById(int id) {
//
//        return projectRepository.findById(id);
//    }
//
//    public void deleteProjectById(int id){
//        projectRepository.deleteById(id);
//    }


    public List<Operation> getOperationById(Integer id) {

        return  operationRepository.findOperationsByEmployeeId(id);
    }

}

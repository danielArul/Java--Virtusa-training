package com.example.ems.service;

import java.util.List;
import java.util.Optional;

import com.example.ems.model.Employee;
import com.example.ems.model.Project;
import com.example.ems.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {

        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
    }
}
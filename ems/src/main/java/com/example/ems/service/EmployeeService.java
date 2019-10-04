package com.example.ems.service;


import com.example.ems.model.Employee;
import com.example.ems.model.Telephone;
import com.example.ems.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepository;

    public Employee save(Employee student) {

        for(Telephone telephone:student.getTelephone()){
            telephone.setStudent(student);
        }

        return employeeRepository.save(student);
    }

    public List<Employee> getEmployee(){

        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id){

        return employeeRepository.findById(id);
    }


}

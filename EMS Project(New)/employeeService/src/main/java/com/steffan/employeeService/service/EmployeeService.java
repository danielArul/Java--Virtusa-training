package com.steffan.employeeService.service;

import com.steffan.employeeService.model.Employee;
import com.steffan.employeeService.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> giveAllEmployees(){
        List<Employee> employees=new ArrayList<>();

                for(Employee e:employeeRepo.findAll()){
                    employees.add(e);
                }
                return employees;
    }

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }
}

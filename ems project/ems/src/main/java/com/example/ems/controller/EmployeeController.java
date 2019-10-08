package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ems")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee){

        return employeeService.save(employee);

    }

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    public List<Employee> getEmployees(){

        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public Optional<Employee> getEmployeeById(@PathVariable int id){

        return employeeService.getEmployeeById(id);
    }



}
package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/empl")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(path="/employee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);

    }
    @GetMapping(path="/employees")
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();


    }
    @RequestMapping("/employee/{eid}")
    public Optional<Employee> getProject(@PathVariable("eid")int eid)
    {
        return employeeService.getEmployeeById(eid);


    }



}
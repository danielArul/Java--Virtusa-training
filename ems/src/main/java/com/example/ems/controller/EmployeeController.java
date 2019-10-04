package com.example.ems.controller;


import com.example.ems.model.Address;
import com.example.ems.model.Telephone;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepo;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ems")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @RequestMapping(value = "/hello")
    public String greetings(){
        return "Hello Springboot";
    }


    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public Employee getEmployee(){

        Employee employee = new Employee();
        employee.setName("Saman");
        Address address = new Address();
        address.setCity("Galle");
        employee.setAddress(address);

        List<Telephone> telephones = new ArrayList<>();
        Telephone telephone = new Telephone();
        telephone.setNumber("045454535353");
        telephones.add(telephone);
        telephone.setStudent(employee);

        employee.setTelephone(telephones);

        return employee;
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee){

        return employeeService.save(employee);

    }

    @RequestMapping(value = "/allemployee",method = RequestMethod.GET)
    public List<Employee> getEmployees(){

        return employeeService.getEmployee();
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public Optional<Employee> getStudentById(@PathVariable int id){

        return employeeService.getEmployeeById(id);
    }
}

package com.steffan.employeeService;

import com.steffan.employeeService.model.Employee;
import com.steffan.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/ems/employees", method= RequestMethod.GET)
    public List<Employee> allEmployees(){
        return employeeService.giveAllEmployees();
    }

    @RequestMapping(value="/ems/employees", method= RequestMethod.POST )
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);

    }


}

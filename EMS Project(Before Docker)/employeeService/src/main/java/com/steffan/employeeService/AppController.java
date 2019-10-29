package com.steffan.employeeService;

import com.steffan.employeeService.model.EPT;
import com.steffan.employeeService.model.EPTdto;
import com.steffan.employeeService.model.Employee;
import com.steffan.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/ems/operation", method=RequestMethod.POST)
    public void createOperation(@RequestBody EPTdto eptdto){
                employeeService.addCreation(eptdto);
    }

    @RequestMapping(value = "/ems/employee/project/{eid}")
    public List<Integer> getPids(@PathVariable Integer eid){
        return employeeService.getPids(eid);
    }

    @RequestMapping(value = "/ems/employee/project/tasks/{eid}/{pid}")
    public List<Integer> getTids(@PathVariable Integer eid,@PathVariable Integer pid){
        return employeeService.getTids(eid,pid);
    }
}

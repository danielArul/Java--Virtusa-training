package com.steffan.employeeService.service;

import com.steffan.employeeService.model.EPT;
import com.steffan.employeeService.model.EPTdto;
import com.steffan.employeeService.model.Employee;
import com.steffan.employeeService.repo.EPTdtorepo;
import com.steffan.employeeService.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;


    @Autowired
    EPTdtorepo eptdtorepo;

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

    public void addCreation(EPTdto eptdto){
        int l= eptdto.getTids().length;

        System.out.println(l);

        for(int i=0; i<l; i++){
            EPT ept= new EPT();
            ept.setEid(eptdto.getEid());
            ept.setPid(eptdto.getPid());
            ept.setTid(eptdto.getTids()[i]);
            System.out.println(ept);
            eptdtorepo.save(ept);

            }
    }
}
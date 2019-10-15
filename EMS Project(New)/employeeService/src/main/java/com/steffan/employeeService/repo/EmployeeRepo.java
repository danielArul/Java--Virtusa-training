package com.steffan.employeeService.repo;

import com.steffan.employeeService.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
}

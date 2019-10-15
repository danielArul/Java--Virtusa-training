package com.example.ems.repository;

import com.example.ems.model.Employee;
import com.example.ems.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationRepo extends JpaRepository<Employee, Integer> {

    @Query("SELECT data FROM Operation data WHERE data.eid=?1")
    public List<Operation> findOperationsByEmployeeId(Integer id);
}

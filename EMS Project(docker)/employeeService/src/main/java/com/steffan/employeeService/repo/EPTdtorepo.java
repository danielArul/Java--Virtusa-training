package com.steffan.employeeService.repo;

import com.steffan.employeeService.model.EPT;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EPTdtorepo extends CrudRepository<EPT, Integer> {

    List<EPT> findByEid(Integer eid);
    List<EPT> findByEidAndPid(Integer eid,Integer pid);
}

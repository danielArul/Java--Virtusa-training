package lk.codelabs.spingdatajpaexample.repository;

import lk.codelabs.spingdatajpaexample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryImpl extends JpaRepository<Student,Integer> {
}
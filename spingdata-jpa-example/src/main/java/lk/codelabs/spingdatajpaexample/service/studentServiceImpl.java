package lk.codelabs.spingdatajpaexample.service;

import lk.codelabs.spingdatajpaexample.model.Student;
import lk.codelabs.spingdatajpaexample.model.Telephone;
import lk.codelabs.spingdatajpaexample.repository.repositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImpl {

    @Autowired
    repositoryImpl repositoryImpl;

    public  Student save(Student s){
        for(Telephone telephone:s.getTelephone()){
            telephone.setStudent(s);
        }
        repositoryImpl.save(s);
        return s;
    }

    public List<Student> getAllStudents() {
        List<Student> students = repositoryImpl.findAll();
        return students;
    }

    public Optional<Student> getStudent(int id) {
        Optional<Student> student = repositoryImpl.findById(id);
        return student;
    }
}

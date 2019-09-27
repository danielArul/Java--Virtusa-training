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
    repositoryImpl studentRepository;


    public Student save(Student student) {

        for(Telephone telephone:student.getTelephones()){
            telephone.setStudent(student);
        }

        return studentRepository.save(student);
    }

    public List<Student> getStudents(){

        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id){

        return studentRepository.findById(id);
    }


}

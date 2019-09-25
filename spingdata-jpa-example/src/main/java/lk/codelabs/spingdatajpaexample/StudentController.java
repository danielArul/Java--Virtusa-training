package lk.codelabs.spingdatajpaexample;

import lk.codelabs.spingdatajpaexample.model.Address;
import lk.codelabs.spingdatajpaexample.model.Student;
import lk.codelabs.spingdatajpaexample.model.Telephone;
import lk.codelabs.spingdatajpaexample.service.studentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sms")
public class StudentController {

    @RequestMapping(value = "/hello")
    public String greetings(){
        return  "Hello Springboot";
    }

    @Autowired
    studentServiceImpl studentService;

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Optional<Student> getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/Student",method = RequestMethod.GET)
    public Student getStudent(){
        Student student=new Student();
        student.setName("Saman");

        Address address=new Address();
        address.setName("Galle");

        student.setAddress(address);

        List<Telephone> telephones=new ArrayList<>();
        Telephone telephone=new Telephone();
        telephone.setNumber("1234567890");
        telephone.setStudent(student);
        telephones.add(telephone);

        student.setTelephone(telephones);

        return  student;
    }
}
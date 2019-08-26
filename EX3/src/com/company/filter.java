package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class filter {


    static void filterWithStream() {
        List<Student> students = Student.getStudent().stream().filter(s -> s.getName().length() <= 6).collect(Collectors.toList());
        System.out.println(students.toString());
    }


    public static void printStudentsWithShortnames() {

        List<Student> students = Student.getStudent();
        for (Student student : students) {
            if (student.getName().length() <= 6) {
                System.out.println(student.getName());
            }
        }
    }
    static void processWithStream() {
        List<Student> students = Student.getStudent().stream().map(s -> new Student("Dr." + s.getName(), s.getId())).collect(Collectors.toList());
        System.out.println(students);
    }

    static void minimum(){
        Student stu=Student.getStudent().stream().min(Comparator.comparing(Student::getId)).get();
        System.out.println(stu.getName());
    }

    static void maximum(){
        Student stu=Student.getStudent().stream().max(Comparator.comparing(Student::getId)).get();
        System.out.println(stu.getName());
    }

    static void count(){
        long count=Student.getStudent().stream().count();
        System.out.println(count);
    }
}

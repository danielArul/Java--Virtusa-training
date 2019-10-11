package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> names=new ArrayList<>();
        names.add("Thilina");
        names.add("Sathurshan");
        names.add("Senthil");
        names.add("Selvan");
        names.add("Pubudu");
        names.add("Mark");
        names.add("Tony");
        names.add("Stephen");
        names.add("Daniel");
        names.add("Paul");

        System.out.println(names);

        Collections.sort(names);

        System.out.println(names);

        List<Student> students=new ArrayList<>();

        Student s1=new Student(1,"Thilina", "Colombo");
        students.add(s1);
        Student s2=new Student(2,"Paul", "Kandy");
        students.add(s2);
        Student s3=new Student(3,"Mark", "Hatton");
        Student s4=new Student(4,"Senthil", "New York");
        Student s5=new Student(5,"Selvan", "Beijing");
        Student s6=new Student(6,"Subangan", "LA");
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(new Student(7,"James", "Atlanta"));
        students.add(new Student(8,"Hanry", "Mumbai"));
        students.add(new Student(9,"Frank", "Singapore"));
        students.add(new Student(10,"George", "England"));

        System.out.println(students);

        Collections.sort(students);

        System.out.println(students);





    }
}

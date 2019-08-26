package com.company;

import java.util.List;

public class sortWithLambda {

    public static void sort(List<Student> s){
        s.sort((Student s1, Student s2)->s1.getId()-s2.getId());

    }

}



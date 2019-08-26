package com.company;

import java.util.List;

public class sortWithLambda {

    public static void sort(List<Student> s){
        s.sort((Student o1, Student o2)->o1.getId()-o2.getId());

    }

}



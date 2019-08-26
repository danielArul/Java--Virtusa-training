package com.company;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Student> s=Student.getStudent();

        //Printing original list
        System.out.println(s);
        //Sorting with traditional method
        Collections.sort(s, new IdComparator());
        System.out.println(s);
        //Sorting with Lambda
        sortWithLambda.sort(s);
        System.out.println(s);

    }
}

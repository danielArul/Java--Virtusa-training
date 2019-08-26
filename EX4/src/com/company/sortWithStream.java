package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class sortWithStream {

    public static void sort(List<Student> s) {
        s= Student.getStudent().stream().sorted((s1, s2) ->
                new Integer(s1.getId()).compareTo(s2.getId())).collect(Collectors.toList());
    }
}

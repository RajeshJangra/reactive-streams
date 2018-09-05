package com.example.reactivestreams.util;

import com.example.reactivestreams.domain.Student;

import java.util.Arrays;
import java.util.List;

public class StudentBootStrap {

  public static List<Student> getStudents() {
    return Arrays.asList(
        new Student(1, "Pankaj"),
        new Student(2, "Rohan"),
        new Student(3, "Ram"),
        new Student(4, "Lakshman"),
        new Student(5, "Anupam"));
  }
}

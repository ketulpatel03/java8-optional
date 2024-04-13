package com.java;

import com.java.dto.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Java8Optional {

    public static void main(String[] args) {

        Student student = new Student(1, "ketul", "patel", "yahoo@email.com", "123");

        // 3 ways to assign an optional Optional.empty(), of() and ofNullable()
        Optional<Object> emptyOptional = Optional.empty();
        Optional<String> emailOptionalOf = Optional.of(student.email());
        Optional<String> emailOptionalOfNullable = Optional.ofNullable(student.contactNo());

        System.out.println("Optional.empty(): " + emptyOptional);
        System.out.println("Optional.of(): " + emailOptionalOf.get());
        System.out.println("Optional.ofNullable(): " + emailOptionalOfNullable.orElse("+11234567890"));

        // always use isPresent() before getting the value from Optional
        System.out.println("isPresent(): " + emailOptionalOfNullable.isPresent());

        // isEmpty()
        System.out.println("isEmpty(): " + emailOptionalOfNullable.isEmpty());

        // orElseThrow()
        System.out.println("orElseThrow(): " + emailOptionalOfNullable
                .orElseThrow(() -> new IllegalArgumentException("contactNo is empty")));

        // realtime usage
        Optional<List<Student>> allStudents = getAllStudents();

        if(allStudents.isPresent()){
            allStudents.get().stream().forEach(e -> System.out.println(e.firstName()));
        }
    }

    private static Optional<List<Student>> getAllStudents() {
        return Optional.ofNullable(Arrays.asList(
                new Student(1, "ketul", "patel", "yahoo@email.com", null),
                new Student(2, "KP", "patel", "yahoo@email.com", null),
                new Student(3, "SP", "patel", "yahoo@email.com", null),
                new Student(4, "PP", "patel", "yahoo@email.com", null),
                new Student(5, "MP", "patel", "yahoo@email.com", null)
        ));
    }

}

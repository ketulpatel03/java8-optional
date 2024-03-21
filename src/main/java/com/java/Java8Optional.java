package com.java;

import com.java.dto.Student;

import java.util.Optional;

public class Java8Optional {

    public static void main(String[] args) {

        Student student = new Student(1, "ketul", "patel", "yahoo@email.com", null);

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
    }

}

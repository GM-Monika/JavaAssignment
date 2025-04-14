
package com.example.studentapi.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    private Integer age;

    // Getters and Setters
}

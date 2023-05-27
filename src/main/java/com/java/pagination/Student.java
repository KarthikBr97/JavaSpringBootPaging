package com.java.pagination;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;


@Entity
@Table(name = "STUDENT_TBL")
@Data

public class Student {
    @Id
    @GeneratedValue
    private  int id;
    private String name;
    private int marks;
    

    public Student(String name, int id, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

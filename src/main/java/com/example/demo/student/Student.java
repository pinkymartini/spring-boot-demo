package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    //below is needed to connect to the dbase.
    @Id
    @SequenceGenerator(
            name= "student_sequence",
            sequenceName= "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;

    @Transient //we dont need age as a seperate column
    private Integer age;
    private LocalDate date_of_birth;
    private String email;

    public Student()
    {

    }

    public Student(Long id, String name,
                   LocalDate date_of_birth, String email) {
        this.id = id;
        this.name = name;

        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    public Student(String name, LocalDate date_of_birth, String email) {
        this.name = name;

        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.date_of_birth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date_of_birth=" + date_of_birth +
                ", email='" + email + '\'' +
                '}';
    }
}

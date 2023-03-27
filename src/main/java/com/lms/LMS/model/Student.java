package com.lms.LMS.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import org.intellij.lang.annotations.Pattern;




@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @NotNull
    private String mobNo;

    private int age;

    private String address;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;






}

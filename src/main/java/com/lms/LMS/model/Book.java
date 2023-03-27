package com.lms.LMS.model;

import com.lms.LMS.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //Book is child wrt to author
    //Setting here the foreign key : Standard 3 steps

    @ManyToOne
    @JoinColumn //Add an extra attribute of authorId (parent table PK) for the foreign key of child table
    private Author author; //This is the parent entity we are connecting with


    //Book is also child wrt Card...
    @ManyToOne
    @JoinColumn
    private Card card;

    private boolean issued;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> listOfTransactions = new ArrayList<>();

}

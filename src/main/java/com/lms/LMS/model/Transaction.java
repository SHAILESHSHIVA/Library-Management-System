package com.lms.LMS.model;

import com.lms.LMS.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Transaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private int fine;

    private String transactionId;

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssueOperation;

    //Things I will write for connecting it book.
    @ManyToOne
    @JoinColumn
    private Book book; //book entity pk will come here and become a foreign key.

    //We need to connect it to the Card class.
    @ManyToOne
    @JoinColumn
    private Card card;

}

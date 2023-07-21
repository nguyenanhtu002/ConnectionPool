package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private double amount;

    public Transaction(int id, Date createdAt, String title, String description, double amount) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.amount = amount;
    }
}
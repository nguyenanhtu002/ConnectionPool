package com.example.demo.dto.response;

import com.example.demo.entity.Transaction;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionResponse {
    private String title;
    private String description;
    private double amount;
    private int id;
    public TransactionResponse(String title, String description, double amount, int id) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.id = id;
    }
}

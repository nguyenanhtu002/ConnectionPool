package com.example.demo.data.dto.Response;

import com.example.demo.data.entity.TagFinance;
import com.example.demo.data.entity.Transactions;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TransactionResponseDTO {
    private String title;
    private String description;
    private double amount;
    private int tagId;
    private String name;
    public TransactionResponseDTO(String title, String description, int amount, String name) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.name = name;
    }

    public TransactionResponseDTO(Transactions transaction){
        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.tagId = transaction.getTagId();
        this.name = transaction.getTagFinance().getName();
    }


}
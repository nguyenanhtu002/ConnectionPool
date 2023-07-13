package com.example.demo.dao;

import com.example.demo.data.entity.Transactions;

import java.util.List;

public interface TransactionDAO {
    List<Transactions> getAllTransactions();

    void createTransaction(String title, String description, double amount, int tagId);

    void updateTransaction(String title, String description, double amount, int tagId) ;

    void deleteTransaction(int id);

}

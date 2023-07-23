package com.example.demo.dao;

import com.example.demo.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getAllTransactions();

    Transaction createTransaction(String title, String description, double amount, int tagId);

    Transaction updateTransaction(String title, String description, double amount, int id);

    void deleteTransaction(int id);

}

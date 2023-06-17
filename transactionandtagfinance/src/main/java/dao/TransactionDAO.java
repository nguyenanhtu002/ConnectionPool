package dao;

import model.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getAllTransactions();

    void insertTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction, int id);

    void deleteTransaction(int id);

    List<Transaction> searchTransactionByTagfinal(int id);

    List<Transaction> searchTransactionByName(String name);
}

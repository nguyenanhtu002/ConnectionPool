package com.example.demo.service.implement;

import com.example.demo.constant.MessageResponse;
import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dao.implement.TransactionDAOImpl;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.entity.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TagFinanceDAO tagFinanceDAO = new TagFinanceDAOImpl();
    private final TransactionDAO transactionDAO = new TransactionDAOImpl();

    public static List<TransactionResponse> transactionDTO = new ArrayList<>();

    @Override
    public BaseResponse createTransaction(String title,String description,double amount,int tagId) {
        Transaction transaction = transactionDAO.createTransaction(title, description, amount, tagId);
        TransactionResponse transactionResponse= new TransactionResponse(
                transaction.getTitle(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getId());
        return new BaseResponse(MessageResponse.SUCCESS, transactionResponse);
    }

    @Override
    public BaseResponse updateTransaction(TransactionRequest transactionRequest, int id) {
        transactionDAO.updateTransaction(
                transactionRequest.getTitle(),
                transactionRequest.getDescription(),
                transactionRequest.getAmount(),
                id);
        return new BaseResponse(MessageResponse.SUCCESS);
    }

    @Override
    public void deleteTransaction(int id) {
        transactionDAO.deleteTransaction(id);
    }

    @Override
    public List<TransactionResponse> getTransaction() {
        List<Transaction> transactionList = transactionDAO.getAllTransactions();
        List<TransactionResponse> transactionDTO = new ArrayList<>();

        for (Transaction transaction : transactionList) {
            TransactionResponse transactionResponse = new TransactionResponse(
                    transaction.getTitle(),
                    transaction.getDescription(),
                    transaction.getAmount(),
                    transaction.getId());
            transactionDTO.add(transactionResponse);
        }
        return transactionDTO;
    }

}

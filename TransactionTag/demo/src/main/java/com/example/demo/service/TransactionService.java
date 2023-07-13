package com.example.demo.service;

import com.example.demo.data.dto.Request.TransactionRequestDTO;
import com.example.demo.data.dto.Response.BaseResponse;
import com.example.demo.data.dto.Response.TransactionResponseDTO;
import jakarta.transaction.Transaction;

import java.util.List;

public interface TransactionService {
    void create(TransactionRequestDTO  transactionRequestDTO) throws Exception;
    void updateTransaction(TransactionRequestDTO  transactionRequestDTO, int tagId) throws Exception;
    void deleteTransaction( int tagId) throws Exception;
    List<TransactionResponseDTO> getTransaction() throws Exception;
}
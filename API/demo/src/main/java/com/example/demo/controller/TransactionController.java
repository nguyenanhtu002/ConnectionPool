package com.example.demo.controller;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/get")
    public List<TransactionResponse> getAll() throws Exception {
        List<TransactionResponse> list = transactionService.getTransaction();
        return list;
    }
    @PostMapping("/create")
    public void create(@RequestBody TransactionRequest transaction) throws Exception {
        transactionService.create(transaction);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) throws Exception {
        transactionService.deleteTransaction(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody TransactionRequest transaction, @PathVariable(name = "id") int id) throws Exception {
        transactionService.updateTransaction(transaction, id);
    }
}

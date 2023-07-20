package com.example.demo.service;

import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.entity.TagFinance;

import java.util.List;

public interface TagFinanceService {
    void createTagFinance(TagfinanceRequest tagfinanceRequestDTO) throws Exception;

    void updateTagFinance(TagfinanceRequest tagfinanceRequestDTO, int Id) throws Exception;

    void deleteTagFinance(int Id) throws Exception;

    List<TagFinanceResponse> getAllTagFinance() throws Exception;

    TagFinance getTagFinanceById(int id) throws Exception;
}
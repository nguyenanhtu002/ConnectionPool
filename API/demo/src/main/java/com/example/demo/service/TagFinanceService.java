package com.example.demo.service;

import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.entity.TagFinance;

import java.util.List;

public interface TagFinanceService {
    BaseResponse createTagFinance(String name, String description);

    BaseResponse updateTagFinance(TagfinanceRequest tagfinanceRequest, int Id);

    void deleteTagFinance(int Id);

    List<TagFinanceResponse> getAllTagFinance();

    TagFinance getTagFinanceById(int id);

}
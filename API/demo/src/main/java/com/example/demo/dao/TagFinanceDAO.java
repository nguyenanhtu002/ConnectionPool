package com.example.demo.dao;

import com.example.demo.entity.TagFinance;

import java.util.List;

public interface TagFinanceDAO {

    TagFinance updateTagFinance(String name, String description, int id);

    TagFinance updateTagFinance(TagFinance tagFinance);

    List<TagFinance> getAllTagFinance();

    void deleteTagFinance(int id);

    TagFinance getTagFinanceById(int id);

    TagFinance createTagFinance(String name, String description);
}

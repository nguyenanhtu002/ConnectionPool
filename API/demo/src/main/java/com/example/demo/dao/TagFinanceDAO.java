package com.example.demo.dao;

import com.example.demo.entity.TagFinance;

import java.util.List;

public interface TagFinanceDAO {

    void updateTagFinance(String name, String description, int id) ;

    List<TagFinance> getAllTagFinance();

    void deleteTagFinance(int id);

    TagFinance getTagFinanceById(int id);

    void createTagFinance(String name, String description);
}

package com.example.demo.dto.response;

import lombok.Getter;
import com.example.demo.entity.TagFinance;
import lombok.Setter;

@Getter
@Setter
public class TagFinanceResponse {
    private String name;
    private String description;

    public TagFinanceResponse(TagFinance tagFinance) {

    }

    public TagFinanceResponse(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
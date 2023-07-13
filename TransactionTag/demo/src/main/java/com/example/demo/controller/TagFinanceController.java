package com.example.demo.controller;

import com.example.demo.data.dto.request.TagfinanceRequestDTO;
import com.example.demo.data.dto.response.TagFinanceResponseDTO;
import com.example.demo.service.TagFinanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tagfinances")
public class TagFinanceController {
    private final TagFinanceService tagFinanceService;

    public TagFinanceController(TagFinanceService tagFinanceService) {
        this.tagFinanceService = tagFinanceService;
    }

    @PostMapping("/create")
    public void create(@RequestBody TagfinanceRequestDTO tagFinance) throws Exception {
        tagFinanceService.createTag(tagFinance);
    }

    @GetMapping("/get")
    public List<TagFinanceResponseDTO> getTagFinance() throws Exception {
        List<TagFinanceResponseDTO> list = tagFinanceService.getAllTagFinance();
        return list;
    }

    @PutMapping("/update/{id}")
    public TagfinanceRequestDTO update(@RequestBody TagfinanceRequestDTO tagFinance, @PathVariable(name = "id") int id) throws Exception {
        tagFinanceService.updateTag(id, tagFinance);
        return tagFinance;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteTagFinance(@PathVariable(name = "id") int tagId) throws Exception {
        tagFinanceService.deleteTag(tagId);
    }

}

package com.example.demo.controller;

import com.example.demo.data.dto.Request.TagfinanceRequestDTO;
import com.example.demo.data.dto.Response.TagFinanceResponseDTO;
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
    public TagfinanceRequestDTO create(@RequestBody TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception {
        tagFinanceService.createTag(tagfinanceRequestDTO);
        return tagfinanceRequestDTO;
    }

    @GetMapping("/get")
    public List<TagFinanceResponseDTO> getTagFinance() throws Exception {
        List<TagFinanceResponseDTO> list = tagFinanceService.getAllTagFinance();
        return list;
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody TagfinanceRequestDTO tagfinanceRequestDTO, @PathVariable(name="id") int id) throws Exception {
        tagFinanceService.updateTag(id,tagfinanceRequestDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTagFinance(@PathVariable(name="id") int tagId) throws Exception {
        tagFinanceService.deleteTag(tagId);
    }

}
package com.example.demo.service.implement;

import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.entity.TagFinance;
import com.example.demo.service.TagFinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagFinanceServiceImpl implements TagFinanceService {
    private final TagFinanceDAO tagFinanceDAO = new TagFinanceDAOImpl();
    public static List<TagFinanceResponse> tagFinanceDTO = new ArrayList<>();

    @Override
    public List<TagFinanceResponse> getAllTagFinance() {
        List<TagFinance> tagFinanceList = tagFinanceDAO.getAllTagFinance();
        List<TagFinanceResponse> tagFinanceDTO = new ArrayList<>();

        for (TagFinance tagFinance : tagFinanceList) {
            String name = tagFinance.getName();
            String description = tagFinance.getDescription();
            TagFinanceResponse tagFinanceResponse = new TagFinanceResponse(name, description);
            tagFinanceDTO.add(tagFinanceResponse);
        }
        return tagFinanceDTO;
    }


    @Override
    public TagFinance getTagFinanceById(int id) {
        return tagFinanceDAO.getTagFinanceById(id);
    }

    @Override
    public void createTagFinance(TagfinanceRequest tagfinanceRequest) {
        tagFinanceDAO.createTagFinance(
                tagfinanceRequest.getName(),
                tagfinanceRequest.getDescription());
    }

    @Override
    public void updateTagFinance(TagfinanceRequest tagfinanceRequest, int Id) {
        tagFinanceDAO.updateTagFinance(
                tagfinanceRequest.getName(),
                tagfinanceRequest.getDescription(),
                Id);
    }

    @Override
    public void deleteTagFinance(int Id) {
        tagFinanceDAO.deleteTagFinance(Id);
    }


}
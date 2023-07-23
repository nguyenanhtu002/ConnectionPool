package com.example.demo.service.implement;

import com.example.demo.constant.MessageResponse;
import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.dao.implement.TagFinanceDAOImpl;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.request.TagfinanceRequest;
import com.example.demo.dto.response.TagFinanceResponse;
import com.example.demo.entity.TagFinance;
import com.example.demo.service.TagFinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    public BaseResponse createTagFinance(String name, String description) {
        TagFinance tagFinance = tagFinanceDAO.createTagFinance(name, description);
        TagFinanceResponse tagFinanceResponse = new TagFinanceResponse(tagFinance);
        return new BaseResponse(MessageResponse.INF_TAG, tagFinanceResponse);
    }




    @Override
    public BaseResponse updateTagFinance(String name, String description, @PathVariable(name = "id") int Id) {
        TagFinance tagfinanceExisted = tagFinanceDAO.getTagFinanceById(Id);
        TagFinance tagfinanceUpdate = new TagFinance(tagfinanceExisted.getId(),name,description);
        tagFinanceDAO.updateTagFinance(tagfinanceUpdate.getName(),tagfinanceUpdate.getDescription(),tagfinanceUpdate.getId());
        return new BaseResponse(MessageResponse.SUCCESS);
    }

    @Override
    public void deleteTagFinance(int Id) {
        tagFinanceDAO.deleteTagFinance(Id);
    }


}
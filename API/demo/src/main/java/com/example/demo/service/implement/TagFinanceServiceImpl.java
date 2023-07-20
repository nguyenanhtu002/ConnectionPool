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
    public List<TagFinanceResponse> getAllTagFinance() throws Exception {
        List<TagFinance> tagFinanceList = tagFinanceDAO.getAllTagFinance();
        for (int i = 0; i < tagFinanceList.size(); i++) {
            TagFinanceResponse tagFinanceResponse = new TagFinanceResponse(tagFinanceList.get(i));
            tagFinanceDTO.add(tagFinanceResponse);
        }
        return tagFinanceDTO;
    }

    @Override
    public TagFinance getTagFinanceById(int id) throws Exception {
        return tagFinanceDAO.getTagFinanceById(id);
    }

    @Override
    public void createTagFinance(TagfinanceRequest tagfinanceRequest) throws Exception {
        tagFinanceDAO.createTagFinance(tagfinanceRequest.getName(), tagfinanceRequest.getDescription());
    }

    @Override
    public void updateTagFinance(TagfinanceRequest tagfinanceRequest, int Id) throws Exception {
        tagFinanceDAO.updateTagFinance(tagfinanceRequest.getName(), tagfinanceRequest.getDescription(), Id);
    }

    @Override
    public void deleteTagFinance(int Id) throws Exception {
        tagFinanceDAO.deleteTagFinance(Id);
    }


}
package dao;

import model.TagFinance;

import java.util.List;

public interface TagFinanceDAO {
    void insert(TagFinance tagFinance);

    List<TagFinance> getAllTagFinance();

    void deleteTagFinance(int id);

    void updateTagFinance(TagFinance tagFinance, int id);
}

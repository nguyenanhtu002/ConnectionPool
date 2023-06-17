package controller;

import dao.TagFinanceDAO;
import dao.implement.TagFinanceDAOImpl;
import model.TagFinance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TagfinanceController {
    private TagFinanceDAO tagFinanceDAO = new TagFinanceDAOImpl();


    public void insertTagFinance() {
        TagFinance tagFinance = createTagFinance();
        tagFinanceDAO.insert(tagFinance);
    }

    public void updateTagFinance(int idUpdate) {
        TagFinance tagFinance = createTagFinance();
        tagFinanceDAO.updateTagFinance(tagFinance, idUpdate);
    }

    public void deleteTagFinance(int idDelete) {
        tagFinanceDAO.deleteTagFinance(idDelete);
    }

    public List<TagFinance> getAllTagFinance() {
        List<TagFinance> list = new ArrayList<>();
        return tagFinanceDAO.getAllTagFinance();
    }


    public TagFinance createTagFinance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter id tagFinance");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter new name tagfinance");
        String name = scanner.nextLine();
        System.out.println("ennter new description tagfinance");
        String description = scanner.nextLine();
        TagFinance tagFinance = new TagFinance(id, name, description);
        return tagFinance;
    }


}

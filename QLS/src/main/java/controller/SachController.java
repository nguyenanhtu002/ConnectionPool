package controller;


import dao.SachDAO;
import dao.SachDAOImpl;
import model.Sach;

import java.util.List;
import java.util.Scanner;

public class SachController {
 private SachDAO sachDAO= new SachDAOImpl();

    public void addSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book Name : ");
        String name = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        Sach sach = new Sach(0, name, author, quantity, price);
        sachDAO.addSach(sach);
    }

    public void updateSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id Update: ");
        int id = scanner.nextInt();
        Sach sach = sachDAO.getSachById(id);
        if (sach != null) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            sach.setName(name);
            sach.setAuthor(author);
            sach.setQuantity(quantity);
            sach.setPrice(price);
            sachDAO.updateSach(sach);
        } else {
            System.out.println("Not Fould " + id);
        }
    }

    public void deleteSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID Delete: ");
        int id = scanner.nextInt();
        Sach sach = sachDAO.getSachById(id);
        if (sach != null) {
            sachDAO.deleteSach(id);
        } else {
            System.out.println("Not Fould = " + id);
        }
    }

    public void searchSachByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Searching Book By : ");
        String name = scanner.nextLine();
        List<Sach> sachs = sachDAO.searchSachByName(name);
        if (sachs.isEmpty()) {
            System.out.println(FouldFould");
        } else {
            for (Sach sach : sachs) {
                System.out.println("Id: " + sach.getId() + " - Name: " + sach.getName() + " - Author: " + sach.getAuthor() + " -  Quantity: " + sach.getQuantity() + " -  Price: " + sach.getPrice());
            }
        }
    }

    public void getSachById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        Sach sach = sachDAO.getSachById(id);
        if (sach != null) {
            System.out.println("Id: " + sach.getId() + " - Name: " + sach.getName() + " - Author: " + sach.getAuthor() + " -  Quantity: " + sach.getQuantity() + " -  Price: " + sach.getPrice());
        } else {
            System.out.println("Not Fould " + id);
        }
    }

    public List<Sach> getAllSach() {
        List<Sach> sachList = sachDAO.getAllSach();
        if (sachList.isEmpty()) {
            System.out.println("Not Fould In Database");
        } else {
            System.out.println("List Book in Database:");
            for (Sach sach : sachList) {
                System.out.println("Id: " + sach.getId() + " - Name: " + sach.getName() + " - Author: " + sach.getAuthor() + " -  Quantity: " + sach.getQuantity() + " -  Price: " + sach.getPrice());
            }
        }
        return sachList;
    }
}

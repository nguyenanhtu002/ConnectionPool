package controller;


import dao.SachDAO;
import dao.SachDAOImpl;
import model.Sach;

import java.util.List;
import java.util.Scanner;

public class SachController {
    private SachDAO sachDAO;

    public SachController() {
        sachDAO = new SachDAOImpl();
    }

    public void addSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten sach: ");
        String name = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        String author = scanner.nextLine();
        System.out.print("Nhap so luong: ");
        int quantity = scanner.nextInt();
        System.out.print("Nhap gia tien: ");
        double price = scanner.nextDouble();
        Sach sach = new Sach(0, name, author, quantity, price);
        sachDAO.addSach(sach);
    }

    public void updateSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id sach can cap nhat: ");
        int id = scanner.nextInt();
        Sach sach = sachDAO.getSachById(id);
        if (sach != null) {
            System.out.print("Nhap ten sach: ");
            String name = scanner.nextLine();
            System.out.print("Nhap tac gia: ");
            String author = scanner.nextLine();
            System.out.print("Nhap so luong: ");
            int quantity = scanner.nextInt();
            System.out.print("Nhap gia tien: ");
            double price = scanner.nextDouble();
            sach.setName(name);
            sach.setAuthor(author);
            sach.setQuantity(quantity);
            sach.setPrice(price);
            sachDAO.updateSach(sach);
        } else {
            System.out.println("Khong ton tai sach co id = " + id);
        }
    }

    public void deleteSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id sach can xoa: ");
        int id = scanner.nextInt();
        Sach sach = sachDAO.getSachById(id);
        if (sach != null) {
            sachDAO.deleteSach(id);
        } else {
            System.out.println("Khong ton tai sach co id = " + id);
        }
    }

    public void searchSachByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten sach can tim kiem: ");
        String name = scanner.nextLine();
        List<Sach> sachs = sachDAO.searchSachByName(name);
        if (sachs.isEmpty()) {
            System.out.println("Khong tim thay sach nao");
        } else {
            for (Sach sach : sachs) {
                System.out.println("Id: " + sach.getId() + " - Name: " + sach.getName() + " - Author: " + sach.getAuthor() + " -  Quantity: " + sach.getQuantity() + " -  Price: " + sach.getPrice());
            }
        }
    }

    public void getSachById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id sach can tim kiem: ");
        int id = scanner.nextInt();
        Sach sach = sachDAO.getSachById(id);
        if (sach != null) {
            System.out.println("Id: " + sach.getId() + " - Name: " + sach.getName() + " - Author: " + sach.getAuthor() + " -  Quantity: " + sach.getQuantity() + " -  Price: " + sach.getPrice());
        } else {
            System.out.println("Khong tim thay sach co id = " + id);
        }
    }

    public List<Sach> getAllSach() {
        List<Sach> sachList = sachDAO.getAllSach();
        if (sachList.isEmpty()) {
            System.out.println("Khong co sach nao trong CSDL");
        } else {
            System.out.println("Danh sach cac sach trong CSDL:");
            for (Sach sach : sachList) {
                System.out.println("Id: " + sach.getId() + " - Name: " + sach.getName() + " - Author: " + sach.getAuthor() + " -  Quantity: " + sach.getQuantity() + " -  Price: " + sach.getPrice());
            }
        }
        return sachList;
    }
}
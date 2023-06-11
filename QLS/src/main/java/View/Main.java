package View;


import controller.SachController;
import model.Sach;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static SachController sachController = new SachController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Them sach");
            System.out.println("2. Cap nhat sach");
            System.out.println("3. Xoa sach");
            System.out.println("4. Tim kiem sach theo ten");
            System.out.println("5. Tim kiem sach theo id");
            System.out.println("6. Hien thi tat ca sach");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    sachController.addSach();
                    break;
                case 2:
                    sachController.updateSach();
                    break;
                case 3:
                    sachController.deleteSach();
                    break;
                case 4:
                    sachController.searchSachByName();
                    break;
                case 5:
                    sachController.getSachById();
                    break;
                case 6:
                    sachController.getAllSach();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println(" chon lai");
            }
        }

    }
}

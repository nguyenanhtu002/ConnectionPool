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
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Id");
            System.out.println("6. Show Book");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choice: ");
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
                    System.out.println("Try Again");
            }
        }

    }
}

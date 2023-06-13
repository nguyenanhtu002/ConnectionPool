package view;


import controller.BookController;

import java.util.Scanner;

public class View {
    private static BookController bookController = new BookController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    bookController.addBook();
                    break;
                case 2:
                    bookController.updateBook();
                    break;
                case 3:
                    bookController.deleteBook();
                    break;
                case 4:
                    bookController.searchBookByName();
                    break;
                case 5:
                    bookController.getBookById();
                    break;
                case 6:
                    bookController.getAllBook();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Try Again");
            }
        }

    }
    private static void showMenu() {
        System.out.println("1. Add Book");
        System.out.println("2. Update Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Search by Name");
        System.out.println("5. Search by Id");
        System.out.println("6. Show Book");
        System.out.println("7. Exit");
        System.out.print("Enter Your Choice: ");
    }
}

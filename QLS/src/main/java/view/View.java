package view;

import controller.BookController;
import model.Book;

import java.util.Scanner;

public class View {
    private static BookController bookController = new BookController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Book book = createBook();
                    bookController.addBook(book);
                    break;
                case 2:
                    System.out.print("id of book you want update: ");
                    int idUpdate = scanner.nextInt();
                    bookController.updateBook(idUpdate);
                    break;
                case 3:
                    System.out.print("id of book you want delete: ");
                    int idDelete = scanner.nextInt();
                    bookController.deleteBook(idDelete);
                    break;
                case 4:
                    System.out.print("name book you want search ");
                    String name = scanner.nextLine();
                    bookController.searchBookByName(name);
                    break;
                case 5:
                    System.out.print("id of book you search: ");
                    int idSearch = scanner.nextInt();
                    bookController.getBookById(idSearch);
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

    public static Book createBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("name book: ");
        String name = scanner.nextLine();
        System.out.print("author: ");
        String author = scanner.nextLine();
        System.out.print("quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("price: ");
        double price = scanner.nextDouble();
        Book book = new Book(0, name, author, quantity, price);
        return book;
    }
}

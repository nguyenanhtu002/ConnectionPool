package controller;


import dao.BookDAO;
import dao.BookDAOImpl;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private BookDAO bookDAO = new BookDAOImpl();

    public Book createBook() {
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

    public void addBook() {
        Book book = createBook();
        bookDAO.addBook(book);
    }

    public void updateBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("id of book you want update: ");
        int id = scanner.nextInt();
        Book book = createBook();
        bookDAO.updateBook(book, id);
    }

    public void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("id of book you want delete: ");
        int id = scanner.nextInt();
        Book book = bookDAO.getBookById(id);
        if (book != null) {
            bookDAO.deleteBook(id);
            System.out.println("success");
        } else {
            System.out.println("not fould id: " + id);
        }
    }

    public void searchBookByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("name book you want search ");
        String name = scanner.nextLine();
        List<Book> books = bookDAO.searchBookByName(name);
        if (books.isEmpty()) {
            System.out.println("not fould");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void getBookById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("id of book you search: ");
        int id = scanner.nextInt();
        Book book = bookDAO.getBookById(id);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("not fould: " + id);
        }
    }

    public List<Book> getAllBook() {
        List<Book> bookList = bookDAO.getAllBook();
        if (bookList.isEmpty()) {
            System.out.println("not fould in DB");
        } else {
            System.out.println("list book in DB:");
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
        return bookList;
    }
}
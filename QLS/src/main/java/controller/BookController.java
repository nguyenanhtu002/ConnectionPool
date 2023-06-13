package controller;


import dao.BookDAO;
import dao.BookDAOImpl;
import model.Book;

import java.util.List;
import java.util.Scanner;

import static view.View.createBook;

public class BookController {
    private BookDAO bookDAO = new BookDAOImpl();


    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void updateBook(Book book,int id) {
        bookDAO.updateBook(book, id);
    }

    public void deleteBook(int id) {
        Book book = bookDAO.getBookById(id);
        if (book != null) {
            bookDAO.deleteBook(id);
            System.out.println("success");
        } else {
            System.out.println("not fould id: " + id);
        }
    }

    public void searchBookByName(String name) {
        List<Book> books = bookDAO.searchBookByName(name);
        if (books.isEmpty()) {
            System.out.println("not fould");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void getBookById(int idSearch) {
        Scanner scanner = new Scanner(System.in);
        Book book = bookDAO.getBookById(idSearch);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("not fould: " + idSearch);
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

package dao;

import java.util.List;

import model.Book;

public interface BookDAO {
    List<Book> getAllBook();

    Book getBookById(int id);

    List<Book> searchBookByName(String name);

    void addBook(Book book);

    void updateBook(Book book, int id);

    void deleteBook(int id);
}
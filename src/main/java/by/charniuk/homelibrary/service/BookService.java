package by.charniuk.homelibrary.service;

import by.charniuk.homelibrary.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    List<Book> search(String words);
    boolean add(Book book);
    boolean remove(Book book);
}

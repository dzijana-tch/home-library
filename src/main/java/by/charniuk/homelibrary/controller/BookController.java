package by.charniuk.homelibrary.controller;

import by.charniuk.homelibrary.model.Book;

import java.util.List;

public interface BookController {

    List<Book> getAll();
    List<Book> search(String words);
    String add(Book book);
    String remove(Book book);

}

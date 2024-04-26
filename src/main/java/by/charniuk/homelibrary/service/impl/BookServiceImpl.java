package by.charniuk.homelibrary.service.impl;

import by.charniuk.homelibrary.model.Book;
import by.charniuk.homelibrary.repository.BookRepository;
import by.charniuk.homelibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> search(String words) {
        List<Book> books;
        books = bookRepository.findAllByAuthorContainingIgnoreCase(words);
        books.addAll(bookRepository.findAllByTitleContainingIgnoreCase(words));
        try {
            int i = Integer.parseInt(words);
            books.addAll(bookRepository.findAllByYear(i));
        } catch (NumberFormatException ignored) {}
        books.addAll(bookRepository.findAllByDescriptionContainingIgnoreCase(words));
        return books;
    }

    @Override
    public boolean add(Book book) {
        if (!bookRepository.findAllByDescription(book.getDescription()).isEmpty()) {
            return false;
        }
        bookRepository.save(book);
        return true;
    }

    @Override
    @Transactional
    public boolean remove(Book book) {
        if (bookRepository.findAllByDescription(book.getDescription()).isEmpty()) {
            return false;
        }
        bookRepository.deleteByDescription(book.getDescription());
        return bookRepository.findAllByDescription(book.getDescription()).isEmpty();
    }
}

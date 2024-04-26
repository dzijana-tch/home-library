package by.charniuk.homelibrary.repository;

import by.charniuk.homelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthorContainingIgnoreCase(String author);
    List<Book> findAllByTitleContainingIgnoreCase(String title);
    List<Book> findAllByYear(int year);
    List<Book> findAllByDescription(String description);
    List<Book> findAllByDescriptionContainingIgnoreCase(String description);
    void deleteByDescription(String description);
}

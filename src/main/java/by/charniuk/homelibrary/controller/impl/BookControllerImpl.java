package by.charniuk.homelibrary.controller.impl;

import by.charniuk.homelibrary.controller.BookController;
import by.charniuk.homelibrary.model.Book;
import by.charniuk.homelibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @GetMapping
    @Override
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("search/{words}")
    @Override
    public List<Book> search(@PathVariable String words) {
        return bookService.search(words);
    }

    @PostMapping("add")
    @Override
    public String add(@RequestBody Book book) {
        if (bookService.add(book)) {
            return "Book added successfully";
        }
        return "This book already exists";
    }

    @DeleteMapping("remove")
    @Override
    public String remove(@RequestBody Book book) {
        if (bookService.remove(book)) {
            return "Book deleted successfully";
        }
        return "Book not found";
    }
}

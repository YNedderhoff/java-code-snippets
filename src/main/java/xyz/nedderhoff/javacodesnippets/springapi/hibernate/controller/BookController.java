package xyz.nedderhoff.javacodesnippets.springapi.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;

import xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities.Book;
import xyz.nedderhoff.javacodesnippets.springapi.hibernate.service.BookService;

@Controller
@RequestMapping("hibernate")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public @ResponseBody
    List<Book> getBooks() {
        return bookService.list();
    }

    @PostMapping("books")
    public @ResponseBody
    Book postBook(
            @RequestBody Book book
    ) {
        validateBook(book);
        return bookService.post(book);
    }

    private void validateBook(Book book) {
        if (Strings.isNullOrEmpty(book.getName())) {
            throw new IllegalArgumentException("name null");
        }

    }
}

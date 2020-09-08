package xyz.nedderhoff.springbootbasic.springapi.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.nedderhoff.springbootbasic.springapi.hibernate.entities.Book;
import xyz.nedderhoff.springbootbasic.springapi.hibernate.service.BookService;

@Controller
@RequestMapping("hibernate")
public class HibernateController {

    private final BookService bookService;

    @Autowired
    public HibernateController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "books")
    public @ResponseBody List<Book> get() {
        return bookService.list();
    }
}

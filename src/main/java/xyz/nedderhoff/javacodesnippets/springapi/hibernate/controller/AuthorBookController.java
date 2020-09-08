package xyz.nedderhoff.javacodesnippets.springapi.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities.AuthorBook;
import xyz.nedderhoff.javacodesnippets.springapi.hibernate.service.AuthorBookService;

@Controller
@RequestMapping("hibernate")
public class AuthorBookController {

    private final AuthorBookService authorBookService;

    @Autowired
    public AuthorBookController(AuthorBookService authorBookService) {
        this.authorBookService = authorBookService;
    }

    @GetMapping("authorbooks")
    public @ResponseBody
    List<AuthorBook> getAuthorBooks() {
        return authorBookService.list();
    }

    @PostMapping("authorbooks")
    public @ResponseBody
    AuthorBook addAuthorBook(
            @RequestBody AuthorBook author
    ) {
        validateAuthorBook(author);
        return authorBookService.add(author);
    }

    private void validateAuthorBook(AuthorBook authorBook) {
        if (authorBook.getAuthor() == null) {
            throw new IllegalArgumentException("author must be present");
        }
        if (authorBook.getAuthor().getId() == null) {
            throw new IllegalArgumentException("author id must be present");
        }

        if (authorBook.getBook() == null) {
            throw new IllegalArgumentException("book must be present");
        }
        if (authorBook.getBook().getId() == null) {
            throw new IllegalArgumentException("book id must be present");
        }
    }
}

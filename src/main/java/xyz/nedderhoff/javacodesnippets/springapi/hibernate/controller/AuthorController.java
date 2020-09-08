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

import xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities.Author;
import xyz.nedderhoff.javacodesnippets.springapi.hibernate.service.AuthorService;

@Controller
@RequestMapping("hibernate")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("authors")
    public @ResponseBody
    List<Author> getAuthors() {
        return authorService.list();
    }

    @PostMapping("authors")
    public @ResponseBody
    Author addAuthor(
            @RequestBody Author author
    ) {
        validateAuthor(author);
        return authorService.add(author);
    }

    private void validateAuthor(Author author) {
        if (Strings.isNullOrEmpty(author.getName())) {
            throw new IllegalArgumentException("name null");
        }
    }
}

package xyz.nedderhoff.javacodesnippets.springapi.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities.AuthorBook;
import xyz.nedderhoff.javacodesnippets.springapi.hibernate.repository.AuthorBookRepository;

@Service
public class AuthorBookService {

    private final AuthorBookRepository authorBookRepository;

    @Autowired
    public AuthorBookService(AuthorBookRepository authorBookRepository) {
        this.authorBookRepository = authorBookRepository;
    }

    public List<AuthorBook> list() {
        return authorBookRepository.findAll();
    }

    public AuthorBook add(AuthorBook author) {
        return authorBookRepository.save(author);
    }
}

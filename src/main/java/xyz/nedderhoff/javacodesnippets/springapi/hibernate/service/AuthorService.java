package xyz.nedderhoff.javacodesnippets.springapi.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities.Author;
import xyz.nedderhoff.javacodesnippets.springapi.hibernate.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> list() {
        return authorRepository.findAll();
    }

    public Author add(Author author) {
        return authorRepository.save(author);
    }
}

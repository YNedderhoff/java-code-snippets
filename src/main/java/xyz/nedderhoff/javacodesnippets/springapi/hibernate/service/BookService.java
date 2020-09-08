package xyz.nedderhoff.javacodesnippets.springapi.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities.Book;
import xyz.nedderhoff.javacodesnippets.springapi.hibernate.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public Book post(Book book) {
        return bookRepository.save(book);
    }
}

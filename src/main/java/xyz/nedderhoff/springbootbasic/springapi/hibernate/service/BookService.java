package xyz.nedderhoff.springbootbasic.springapi.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.nedderhoff.springbootbasic.springapi.hibernate.entities.Book;
import xyz.nedderhoff.springbootbasic.springapi.hibernate.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }
}

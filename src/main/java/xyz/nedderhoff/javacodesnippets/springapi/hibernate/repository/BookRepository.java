package xyz.nedderhoff.javacodesnippets.springapi.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

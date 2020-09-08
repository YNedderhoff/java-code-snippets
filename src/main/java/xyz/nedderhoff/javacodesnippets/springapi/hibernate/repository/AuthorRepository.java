package xyz.nedderhoff.javacodesnippets.springapi.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

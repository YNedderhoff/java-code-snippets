package xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private Set<AuthorBook> authorBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthorBook> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(Set<AuthorBook> authorBook) {
        this.authorBooks = authorBook;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorBooks=" + authorBooks +
                '}';
    }
}

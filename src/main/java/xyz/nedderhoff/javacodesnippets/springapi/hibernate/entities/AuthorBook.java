package xyz.nedderhoff.javacodesnippets.springapi.hibernate.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AuthorBook {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "isMainAuthor")
    private boolean isMainAuthor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public Author getAuthor() {
        return author;
    }

    @JsonProperty
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonIgnore
    public Book getBook() {
        return book;
    }

    @JsonProperty
    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isIsMainAuthor() {
        return isMainAuthor;
    }

    public void setIsMainAuthor(boolean bought) {
        this.isMainAuthor = bought;
    }

    @Override
    public String toString() {
        return "AuthorBook{" +
                "id=" + id +
                ", author=" + author +
                ", book=" + book +
                ", isMainAuthor=" + isMainAuthor +
                '}';
    }
}

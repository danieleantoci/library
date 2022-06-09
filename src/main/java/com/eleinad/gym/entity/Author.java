package com.eleinad.gym.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", insertable = false, updatable = false, nullable = false)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",
                    referencedColumnName = "id"))
    private List<Book> books;

    @Transient
    @JsonIgnore
    public void addBook(Book book) {
        List<Book> books = getBooks();
        if(Objects.isNull(books)) {
            books = new ArrayList<>();
        }
        books.add(book);
    }
}

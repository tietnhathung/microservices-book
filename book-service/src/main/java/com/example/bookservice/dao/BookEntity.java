package com.example.bookservice.dao;

import com.example.commonslibrary.model.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;

    public BookEntity() {
    }
    public BookEntity(Book book) {
        id = book.getId();
        name = book.getName();
        author = book.getAuthor();
    }
    public Book toModel(){
        return new Book(id,name,author);
    }
}
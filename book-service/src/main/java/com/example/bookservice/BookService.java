package com.example.bookservice;


import com.example.bookservice.dao.BookEntity;
import com.example.bookservice.dao.BookRepository;
import com.example.commonslibrary.model.Book;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> get() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream().map(bookEntity -> new Book(bookEntity.getId(), bookEntity.getName(), bookEntity.getAuthor())).collect(Collectors.toList());
    }

    public Book create(Book book) {
        BookEntity bookEntity = bookRepository.save(new BookEntity(book));
        return bookEntity.toModel();
    }

    public Book find(UUID id) {
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        return bookEntity.map(BookEntity::toModel).orElse(null);
    }

    public Book update(UUID bookId, Book book) throws Exception {
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
        if (bookEntity.isEmpty()){
            throw new NotFoundException("Not found");
        }
        BookEntity bookUpdate =  bookEntity.get();
        bookUpdate.setName(book.getName());
        bookUpdate.setAuthor(book.getAuthor());
        bookUpdate = bookRepository.save(bookUpdate);
        return bookUpdate.toModel();
    }

    public void delete(UUID bookId) {
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
        if (bookEntity.isEmpty()){
            throw new NotFoundException("Not found");
        }
        bookRepository.delete(bookEntity.get());
    }
}

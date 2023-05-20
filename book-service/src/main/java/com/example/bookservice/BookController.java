package com.example.bookservice;

import com.example.commonslibrary.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> get(){
        return bookService.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }

    @GetMapping("{id}")
    public Book find(@PathVariable String id){
        UUID bookId = UUID.fromString(id);
        return bookService.find(bookId);
    }
    @PutMapping("{id}")
    public Book update(@PathVariable String id,@RequestBody Book book) throws Exception {
        UUID bookId = UUID.fromString(id);
        return bookService.update(bookId,book);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        UUID bookId = UUID.fromString(id);
        bookService.delete(bookId);
    }
}

package com.example.commonslibrary.clients;

import com.example.commonslibrary.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("BOOK-SERVICE")
public interface BookClient {
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    List<Book> get();
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    Book create(@RequestBody Book book);
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    Book find(@PathVariable String id);
    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    Book update(@PathVariable String id,@RequestBody Book book);
    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable String id);
}

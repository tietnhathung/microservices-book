package com.example.commonslibrary.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("BOOK-SERVICE")
public interface BookClient {
    @RequestMapping("/book")
    String get();
}

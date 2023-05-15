package com.example.commonslibrary.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("INVENTORY-SERVICE")
public interface InventoryClient {
    @RequestMapping("/inventory")
    String get();
}

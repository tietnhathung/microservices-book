package com.example.commonslibrary.clients;

import com.example.commonslibrary.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("INVENTORY-SERVICE")
public interface InventoryClient {
    @RequestMapping("/inventory")
    String quantityAdjustment(@RequestBody Inventory inventory);

    @RequestMapping("/inventory/isInStock")
    Boolean isInStock(@RequestBody Inventory inventory);
}

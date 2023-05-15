package com.example.voucherservice;

import com.example.commonslibrary.clients.BookClient;
import com.example.commonslibrary.clients.InventoryClient;
import jakarta.inject.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voucher")
public class VoucherController {
    private final InventoryClient inventoryClient;
    private final BookClient bookClient;

    public VoucherController(InventoryClient inventoryClient, BookClient bookClient) {

        this.inventoryClient = inventoryClient;
        this.bookClient = bookClient;
    }

    @GetMapping
    public String get(){
        String inventory = inventoryClient.get();
        String book = bookClient.get();

        return "voucher service";
    }
}

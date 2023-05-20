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

    @GetMapping
    public String get(){
        return "voucher service";
    }
}

package com.example.commonslibrary.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("VOUCHER-SERVICE")
public interface VoucherClient {
    @RequestMapping("/voucher")
    String get();
}

package com.example.voucherservice;

import com.example.commonslibrary.model.Voucher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController {
    private final VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping
    public List<Voucher> get(){
        return voucherService.get();
    }

    @PostMapping
    public Voucher create(@RequestBody Voucher voucher) throws Exception {
        return voucherService.create(voucher);
    }

}

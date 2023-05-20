package com.example.commonslibrary.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Voucher {
    private UUID id;

    private String code;

    private String address;

    private List<VoucherBook> voucherBooks;
}

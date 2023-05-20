package com.example.commonslibrary.model;

import lombok.Data;

import java.util.UUID;

@Data
public class VoucherBook {
    private UUID id;

    private Voucher voucher;

    private UUID bookId;

    private Integer quantity;
}

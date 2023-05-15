package com.example.voucherservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "voucher_book_entity")
public class VoucherBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "voucher_id", nullable = false)
    private UUID voucherId;

    @Column(name = "book_id", nullable = false)
    private UUID bookId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
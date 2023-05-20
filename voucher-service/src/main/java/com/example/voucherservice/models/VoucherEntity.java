package com.example.voucherservice.models;

import com.example.commonslibrary.model.Voucher;
import com.example.commonslibrary.model.VoucherBook;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "voucher")
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "voucherEntity")
    private List<VoucherBookEntity> voucherBookEntities;

    public VoucherEntity() {
    }

    public VoucherEntity(Voucher voucher) {
        id = voucher.getId();
        code = voucher.getCode();
        address = voucher.getAddress();
    }

    public Voucher toModel() {
        Voucher voucher = new Voucher();
        voucher.setId(id);
        voucher.setCode(code);
        voucher.setAddress(address);
        if (voucherBookEntities != null) {
            voucher.setVoucherBooks(voucherBookEntities.stream().map(voucherBookEntity -> voucherBookEntity.toModel(null)).toList());
        }
        return voucher;
    }

    public Voucher toModel(List<VoucherBook> voucherBooks) {
        Voucher voucher = new Voucher();
        voucher.setId(id);
        voucher.setCode(code);
        voucher.setAddress(address);
        voucher.setVoucherBooks(voucherBooks);
        return voucher;
    }
}
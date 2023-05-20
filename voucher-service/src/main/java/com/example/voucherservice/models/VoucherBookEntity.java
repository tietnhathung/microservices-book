package com.example.voucherservice.models;

import com.example.commonslibrary.model.Voucher;
import com.example.commonslibrary.model.VoucherBook;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "voucher_book")
public class VoucherBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "book_id", nullable = false)
    private UUID bookId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="voucher_id", nullable=false)
    private VoucherEntity voucherEntity;

    public VoucherBookEntity() {
    }
    public VoucherBookEntity(VoucherBook voucherBook) {
        id = voucherBook.getId();
        bookId = voucherBook.getBookId();
        quantity = voucherBook.getQuantity();
    }
    public VoucherBook toModel(){
        VoucherBook voucherBook = new VoucherBook();
        voucherBook.setId(id);
        voucherBook.setVoucher(voucherEntity.toModel());
        voucherBook.setBookId(bookId);
        voucherBook.setQuantity(quantity);
        return voucherBook;
    }

    public VoucherBook toModel(Voucher voucher){
        VoucherBook voucherBook = new VoucherBook();
        voucherBook.setId(id);
        voucherBook.setVoucher(voucher);
        voucherBook.setBookId(bookId);
        voucherBook.setQuantity(quantity);
        return voucherBook;
    }
}
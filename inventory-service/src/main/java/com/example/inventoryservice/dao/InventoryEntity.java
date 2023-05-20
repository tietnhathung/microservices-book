package com.example.inventoryservice.dao;

import com.example.commonslibrary.model.Inventory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "book_id", nullable = false)
    private UUID bookId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public InventoryEntity() {
    }

    public InventoryEntity(Inventory inventory) {
        this.id = inventory.getId();
        this.bookId = inventory.getBookId();
        this.quantity = inventory.getQuantity();
    }

    public Inventory toModel(){
        return new Inventory(id,bookId,quantity);
    }
}
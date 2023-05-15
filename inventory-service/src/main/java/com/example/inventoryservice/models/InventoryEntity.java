package com.example.inventoryservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Internal;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "inventory_entity")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "book_id", nullable = false)
    private UUID bookId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
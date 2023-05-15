package com.example.inventoryservice.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryEntityRepository extends JpaRepository<InventoryEntity, UUID> {
}
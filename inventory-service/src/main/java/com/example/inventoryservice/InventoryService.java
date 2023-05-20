package com.example.inventoryservice;

import com.example.commonslibrary.model.Inventory;
import com.example.inventoryservice.dao.InventoryEntity;
import com.example.inventoryservice.dao.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Boolean isInStock(Inventory inventory) {
        Optional<InventoryEntity> inventoryEntity = inventoryRepository.findByBookId(inventory.getBookId());
        return inventoryEntity.filter(entity -> entity.getQuantity() >= inventory.getQuantity()).isPresent();
    }
}

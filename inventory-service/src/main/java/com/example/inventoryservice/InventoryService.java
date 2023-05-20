package com.example.inventoryservice;

import com.example.commonslibrary.model.Inventory;
import com.example.inventoryservice.dao.InventoryEntity;
import com.example.inventoryservice.dao.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryEntity findOrNew(UUID bookId){
        Optional<InventoryEntity> inventoryEntityOpt = inventoryRepository.findByBookId(bookId);
        InventoryEntity inventoryEntity;
        if(inventoryEntityOpt.isPresent()){
            inventoryEntity = inventoryEntityOpt.get();
        }else{
            inventoryEntity = new InventoryEntity();
            inventoryEntity.setBookId(bookId);
            inventoryEntity.setQuantity(0);
        }
        return inventoryEntity;
    }

    public Boolean isInStock(Inventory inventory) {
        InventoryEntity inventoryEntity = findOrNew(inventory.getBookId());
        return inventoryEntity.getQuantity() >= inventory.getQuantity();
    }

    public Inventory quantityAdjustment(Inventory inventory) throws Exception {
        InventoryEntity inventoryEntity = findOrNew(inventory.getBookId());
        int newQuantity = inventoryEntity.getQuantity() + inventory.getQuantity();
        if(newQuantity < 0){
            throw new Exception("Số lượng không đủ");
        }
        inventoryEntity.setQuantity( inventoryEntity.getQuantity() + inventory.getQuantity() );
        inventoryRepository.save(inventoryEntity);
        return inventoryEntity.toModel();
    }
}

package com.example.inventoryservice;

import com.example.commonslibrary.model.Inventory;
import com.example.commonslibrary.utils.LockByKey;
import com.example.inventoryservice.dao.InventoryEntity;
import com.example.inventoryservice.dao.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final LockByKey lockByKey;

    public InventoryService(InventoryRepository inventoryRepository, LockByKey lockByKey) {
        this.inventoryRepository = inventoryRepository;
        this.lockByKey = lockByKey;
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

    @Transactional
    public Inventory quantityAdjustment(Inventory inventory) throws Exception {
        lockByKey.lock(inventory.getBookId().toString());
        InventoryEntity inventoryEntity = findOrNew(inventory.getBookId());
        int newQuantity = inventoryEntity.getQuantity() + inventory.getQuantity();
        if(newQuantity < 0){
            throw new Exception("Số lượng không đủ");
        }
        inventoryEntity.setQuantity( inventoryEntity.getQuantity() + inventory.getQuantity() );
        inventoryRepository.save(inventoryEntity);
        lockByKey.unlock(inventory.getBookId().toString());
        return inventoryEntity.toModel();
    }
}

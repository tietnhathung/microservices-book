package com.example.inventoryservice;

import com.example.commonslibrary.model.Inventory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("isInStock")
    public Boolean isInStock(@RequestBody Inventory inventory){
        return inventoryService.isInStock(inventory);
    }

    @PostMapping
    public Inventory quantityAdjustment(@RequestBody Inventory inventory) throws Exception {
        return inventoryService.quantityAdjustment(inventory);
    }
}

package com.example.inventoryservice;

import com.example.commonslibrary.model.Inventory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> get(){
        return inventoryService.all();
    }
    @PostMapping("isInStock")
    public Boolean isInStock(@RequestBody Inventory inventory){
        return inventoryService.isInStock(inventory);
    }

    @PostMapping
    public Inventory quantityAdjustment(@RequestBody Inventory inventory) throws Exception {
        Inventory update = inventory;
        update =  inventoryService.quantityAdjustment(update);
        return update;
    }
}

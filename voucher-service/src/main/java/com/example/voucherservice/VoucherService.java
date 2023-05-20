package com.example.voucherservice;

import com.example.commonslibrary.clients.InventoryClient;
import com.example.commonslibrary.model.Inventory;
import com.example.commonslibrary.model.Voucher;
import com.example.commonslibrary.model.VoucherBook;
import com.example.voucherservice.models.VoucherBookEntity;
import com.example.voucherservice.models.VoucherBookRepository;
import com.example.voucherservice.models.VoucherEntity;
import com.example.voucherservice.models.VoucherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    private final InventoryClient inventoryClient;
    private final VoucherRepository voucherRepository;
    private final VoucherBookRepository voucherBookRepository;

    public VoucherService(InventoryClient inventoryClient, VoucherRepository voucherRepository, VoucherBookRepository voucherBookRepository) {
        this.inventoryClient = inventoryClient;
        this.voucherRepository = voucherRepository;
        this.voucherBookRepository = voucherBookRepository;
    }

    List<Voucher> get(){
        List<VoucherEntity> voucherEntities = voucherRepository.findAllWithDetail();
        return voucherEntities.stream().map(VoucherEntity::toModel).toList();
    }
    @Transactional
    public Voucher create(Voucher voucher) throws Exception {
        for (VoucherBook voucherBook : voucher.getVoucherBooks()) {
            Inventory inventory = new Inventory();
            inventory.setBookId(voucherBook.getBookId());
            inventory.setQuantity(voucherBook.getQuantity());
            Boolean isInStock = inventoryClient.isInStock(inventory);
            if (!isInStock){
                throw new Exception("Quantity of product is not in stock");
            }
        }
        VoucherEntity voucherEntity = new VoucherEntity(voucher);
        VoucherEntity saved =  voucherRepository.save(voucherEntity);
        List<VoucherBookEntity> voucherBookEntities = voucher.getVoucherBooks().stream().map(voucherBook -> {
            VoucherBookEntity voucherBookEntity = new VoucherBookEntity(voucherBook);
            voucherBookEntity.setVoucherEntity(saved);
            return voucherBookEntity;
        }).toList();
        voucherBookRepository.saveAll(voucherBookEntities);
        saved.setVoucherBookEntities(voucherBookEntities);
        return saved.toModel();
    }
}

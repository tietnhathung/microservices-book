package com.example.voucherservice.models;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface VoucherRepository extends JpaRepository<VoucherEntity, UUID> {
    @EntityGraph(attributePaths = {"voucherBookEntities"})
    @Query(value = "select voucher from VoucherEntity as voucher")
    List<VoucherEntity> findAllWithDetail();
}
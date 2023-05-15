package com.example.voucherservice.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoucherEntityRepository extends JpaRepository<VoucherEntity, UUID> {
}
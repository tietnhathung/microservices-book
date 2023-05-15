package com.example.bookservice.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookEntityRepository extends JpaRepository<BookEntity, UUID> {
}
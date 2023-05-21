package com.example.inventoryservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class InventoryServiceApplicationTests {
    @Autowired
    InventoryController inventoryController;

    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    void contextLoads() {
        assertThat(restTemplate).isNotNull();
        assertThat(inventoryController).isNotNull();
    }
}

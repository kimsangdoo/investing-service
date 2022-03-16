package com.kb.investingservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    private final ProductRepository productRepository;

    public ProductRepositoryTest(@Autowired ProductRepository productRepository) { this.productRepository = productRepository; }

    @Test
    void findAllProduct() {
    }
}
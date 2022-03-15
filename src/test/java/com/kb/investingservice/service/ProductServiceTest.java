package com.kb.investingservice.service;

import com.kb.investingservice.domain.Product;
import com.kb.investingservice.dto.ProductDto;
import com.kb.investingservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks private ProductService productService;
    @Mock private ProductRepository productRepository;

    @Test
    void searchALl() {

    }

}
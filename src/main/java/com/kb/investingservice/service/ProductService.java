package com.kb.investingservice.service;

import com.kb.investingservice.domain.Product;
import com.kb.investingservice.dto.ProductDto;
import com.kb.investingservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> searchALl() {
        List<Product> list = productRepository.findAllProduct();

        return list.stream().map(ProductDto::of).collect(Collectors.toList());
    }
}

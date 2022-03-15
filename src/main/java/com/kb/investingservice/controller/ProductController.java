package com.kb.investingservice.controller;

import com.kb.investingservice.dto.ProductDto;
import com.kb.investingservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/searchAll")
    public ResponseEntity<List<ProductDto>> searchAll() {
        List<ProductDto> list = productService.searchALl();
        return ResponseEntity.ok(list);
    }

}

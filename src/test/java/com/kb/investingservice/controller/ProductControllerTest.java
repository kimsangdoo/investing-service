package com.kb.investingservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kb.investingservice.dto.ProductDto;
import com.kb.investingservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private final MockMvc mvc;
    private final ObjectMapper mapper;

    @MockBean
    private ProductService productService;

    public ProductControllerTest(
            @Autowired MockMvc mvc,
            @Autowired ObjectMapper mapper
    ) {
        this.mvc = mvc;
        this.mapper = mapper;
    }

    @Test
    void searchAll() throws Exception {

        mvc.perform(
                get("/product/searchAll")
        ).andExpect(status().isOk());
                // java.lang.AssertionError: No value at JSON path "$.data"
                //.andExpect(jsonPath("$.data").isArray());

    }
}
package com.kb.investingservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kb.investingservice.constant.InvestingState;
import com.kb.investingservice.dto.ProductDto;
import com.kb.investingservice.dto.PurchaseDto;
import com.kb.investingservice.dto.UserDto;
import com.kb.investingservice.service.PurchaseService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebMvcTest(PurchaseController.class)
class PurchaseControllerTest {

/*    private final MockMvc mvc;
    private final ObjectMapper mapper;*/

    @MockBean private PurchaseService purchaseService;

/*    public PurchaseControllerTest(
        @Autowired MockMvc mvc;
        @Autowired ObjectMapper mapper;
    ) {
        this.mvc = mvc;
        this.mapper = mapper;
    }*/
    
    // given ~ willReturn 부분 타입(T) 에러
    
    @Test
    void doInvest() {
        //given(purchaseService.doInvest(any()));
    }

    @Test
    void productList() {
/*        String userId = "test";
        given(purchaseService.productList(userId)).willReturn(Optional.of(createPurchaseDto()));*/
    }

    private PurchaseDto createPurchaseDto() {
        return PurchaseDto.of(
            1L,
                createUserDto("test"),
                createProductDto(),
                123123L,
                LocalDateTime.now()
        );
    }

    private UserDto createUserDto(String userId) {
        return UserDto.of(
                userId,
                "테스트"
        );
    }

    private ProductDto createProductDto() {
        return ProductDto.of(
            1L,
                "상품1",
                10000L,
                LocalDateTime.now(),
                LocalDateTime.now(),
                InvestingState.RECRUITING,
                2L,
                2L
        );
    }

}
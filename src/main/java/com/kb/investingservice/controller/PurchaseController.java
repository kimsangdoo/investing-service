package com.kb.investingservice.controller;

import com.kb.investingservice.dto.*;
import com.kb.investingservice.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    // 2. 투자하기 -> /purchase/do
    // 입력값: 사용자 key, 상품id, 투자 금액
    // 총 투자모집 금액(total_investing_amount)을 넘어서면 sold-out 상태를 응답
    @PostMapping("/doInvest/{userId}/{productId}")
    public ResponseEntity<?> doInvest(
        @PathVariable String userId,
        @PathVariable Long productId,
        @RequestBody PurchaseRequest purchaseRequest) {

        purchaseService.doInvest(purchaseRequest.toDto(UserDto.isOnly(userId), ProductDto.isOnly(productId)));

        return ResponseEntity.ok().build();
    }

    // 3. 나의 투자상품 조회 -> /product/{userId}
    // 내가 투자한 상품 모두 반환
    // return값: 상품id, 상품제목, 총 모집금액, 나의 투자금액, 투자일시
    // --> 총 모집금액(product 테이블) 제외 전부 purchase 테이블 => User는 아예 없어도됨
    @GetMapping("/product/{userId}")
    public ResponseEntity<List<PurchaseDto>> productList(@PathVariable String userId) {
        List<PurchaseDto> list = purchaseService.productList(userId);

        return ResponseEntity.ok(list);

    }

}

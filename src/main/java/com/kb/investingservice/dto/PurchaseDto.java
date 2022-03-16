package com.kb.investingservice.dto;

import com.kb.investingservice.domain.Product;
import com.kb.investingservice.domain.Purchase;
import com.kb.investingservice.domain.User;

import java.time.LocalDateTime;

public record PurchaseDto(
        Long purchaseId,
        UserDto userDto,
        ProductDto productDto,
        Long invAmt,
        LocalDateTime invDate
) {

    public static PurchaseDto of(
            Long purchaseId,
            UserDto userDto,
            ProductDto productDto,
            Long invAmt,
            LocalDateTime invDate
    ) {
        return new PurchaseDto(purchaseId, userDto, productDto, invAmt, invDate);
    }

    public static PurchaseDto of(Purchase purchase) {
        return new PurchaseDto(
                purchase.getPurchaseId(),
                UserDto.of(purchase.getUser()),
                ProductDto.of(purchase.getProduct()),
                purchase.getInvAmt(),
                purchase.getInvDate()
        );
    }


    public Purchase toEntity(User user, Product product) {
        return Purchase.of(
                purchaseId,
                user,
                product,
                invAmt,
                invDate
        );
    }


}

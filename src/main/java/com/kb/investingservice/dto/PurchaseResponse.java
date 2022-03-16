package com.kb.investingservice.dto;

import java.time.LocalDateTime;

public record PurchaseResponse(
        Long purchaseId,
        UserDto user,
        ProductDto product,
        Long invAmt,
        LocalDateTime invDate
) {

    public static PurchaseResponse of(
            Long purchaseId,
            UserDto user,
            ProductDto product,
            Long invAmt,
            LocalDateTime invDate
    ) {
        return new PurchaseResponse(purchaseId, user, product, invAmt, invDate);
    }

}

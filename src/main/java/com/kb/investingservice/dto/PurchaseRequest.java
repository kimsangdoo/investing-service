package com.kb.investingservice.dto;

import java.time.LocalDateTime;

public record PurchaseRequest(
        Long purchaseId,
        Long invAmt,
        LocalDateTime invDate
) {

    public static PurchaseRequest of(
            Long purchaseId,
            Long invAmt,
            LocalDateTime invDate
    ) {
        return new PurchaseRequest(purchaseId, invAmt, invDate);
    }

    public PurchaseDto toDto(UserDto userDto, ProductDto productDto) {
        return PurchaseDto.of(
                this.purchaseId(),
                userDto,
                productDto,
                this.invAmt(),
                this.invDate()
        );
    }

}

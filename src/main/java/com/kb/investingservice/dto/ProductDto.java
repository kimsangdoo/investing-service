package com.kb.investingservice.dto;

import com.kb.investingservice.constant.InvestingState;
import com.kb.investingservice.domain.Product;

import java.time.LocalDateTime;

public record ProductDto(
        Long productId,
        String title,
        Long totInvAmt,
        LocalDateTime startedAt,
        LocalDateTime finishedAt,
        InvestingState invState,
        Long sum_amt,
        Long sum_product
) {

    public static ProductDto isOnly(Long productId) {
        return ProductDto.of(productId, null, null, null, null, null, null, null);
    }

    public static ProductDto of(
            Long productId,
            String title,
            Long totInvAmt,
            LocalDateTime startedAt,
            LocalDateTime finishedAt,
            InvestingState invState,
            Long sumAmt,
            Long sumProduct
    ) {
        return new ProductDto(productId, title, totInvAmt, startedAt, finishedAt, invState, sumAmt, sumProduct);
    }

    public static ProductDto of(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getTitle(),
                product.getTotInvAmt(),
                product.getStartedAt(),
                product.getFinishedAt(),
                product.getInvState(),
                product.getSumAmt(),
                product.getSumProduct()
        );
    }

}

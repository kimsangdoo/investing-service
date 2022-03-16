package com.kb.investingservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@ToString
public class Purchase {

    /*
    PURCHASE_ID
    USER_ID
    PRODUCT_ID
    INVESTING_AMOUNT				투자_금액
    INVESTING_DATE					투자_일시
    */

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    private Long invAmt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime invDate;

    protected Purchase() {}
    protected Purchase(
        Long purchaseId,
        User user,
        Product product,
        Long invAmt,
        LocalDateTime invDate
    ) {
        this.purchaseId = purchaseId;
        this.user = user;
        this.product = product;
        this.invAmt = invAmt;
        this.invDate = invDate;
    }

    public static Purchase of(
            Long purchaseId,
            User user,
            Product product,
            Long invAmt,
            LocalDateTime invDate
    ) {
        return new Purchase(purchaseId, user, product, invAmt, invDate);
    }

}

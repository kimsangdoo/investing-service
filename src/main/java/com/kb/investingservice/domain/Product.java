package com.kb.investingservice.domain;

import com.kb.investingservice.constant.InvestingState;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Product {

    /*
    PRODUCT_ID						상품_ID					PK
    TITLE							투자명
    TOTAL_INVESTING_AMOUNT		총_투자_모집금액
    STARTED_AT						투자_시작일시
    FINISHED_AT						투자_종료일시
    INVESTING_STATE				투자모집_상태     --> enum 처리하자
     */

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases = new ArrayList<>();

    private String title;
    private Long totInvAmt;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    @Enumerated(EnumType.STRING)
    private InvestingState invState;

    private Long sumAmt;
    private Long sumProduct;


}

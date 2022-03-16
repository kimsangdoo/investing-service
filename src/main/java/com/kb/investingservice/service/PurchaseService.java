package com.kb.investingservice.service;

import com.kb.investingservice.domain.Product;
import com.kb.investingservice.domain.Purchase;
import com.kb.investingservice.domain.User;
import com.kb.investingservice.dto.PurchaseDto;
import com.kb.investingservice.dto.PurchaseResponse;
import com.kb.investingservice.repository.ProductRepository;
import com.kb.investingservice.repository.PurchaseRepository;
import com.kb.investingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    public void doInvest(PurchaseDto purchaseDto) {
        User user = userRepository.getById(purchaseDto.userDto().userId());
        Product product = productRepository.getById(purchaseDto.productDto().productId());
        purchaseRepository.save(purchaseDto.toEntity(user, product));
    }

    public List<PurchaseDto> productList(String userId) {
        List<Purchase> list = purchaseRepository.findByUser_UserId(userId);
        // Purchase -> of(Purchase purchase)
        return list.stream().map(PurchaseDto::of).collect(Collectors.toList());
    }
}

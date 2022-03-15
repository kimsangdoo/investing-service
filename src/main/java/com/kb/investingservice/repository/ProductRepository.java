package com.kb.investingservice.repository;

import com.kb.investingservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //@Query(value = "select DISTINCT p from Product p left join fetch p.purchases")
    @Query(value="select a.product_id, a.title, a.tot_inv_amt, a.inv_state, a.started_at, a.finished_at, b.sum_amt, b.sum_product from product a\n" +
            "join (select count(inv_amt) as sum_amt, count(product_id) as sum_product, product_id from purchase\n" +
            "group by product_id) b on a.product_id = b.product_id", nativeQuery=true)
    List<Product> findAllProduct();
}

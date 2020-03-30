package com.juanlamb.hackathon.modules.purchase;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.domain.Purchase;
import com.juanlamb.hackathon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {

    List<Purchase> findByBuyer(User buyer);

    List<Purchase> findByProduct_Business(Business business);
}

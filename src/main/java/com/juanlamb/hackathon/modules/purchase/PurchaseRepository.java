package com.juanlamb.hackathon.modules.purchase;

import com.juanlamb.hackathon.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
}

package com.juanlamb.hackathon.modules.business;

import com.juanlamb.hackathon.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}

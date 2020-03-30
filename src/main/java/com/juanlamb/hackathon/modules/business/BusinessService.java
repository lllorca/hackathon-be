package com.juanlamb.hackathon.modules.business;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.domain.BusinessCategory;
import com.juanlamb.hackathon.domain.User;
import com.juanlamb.hackathon.exception.NotFoundException;
import com.juanlamb.hackathon.security.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final AuthorizationService authorizationService;

    public Business create(Business business) {
        User loggedInUser = authorizationService.getLoggedInUser();
        if (businessRepository.findByOwner(loggedInUser).isPresent()) {
            throw new IllegalArgumentException("User already has a business");
        }
        business.setOwner(loggedInUser);
        return businessRepository.save(business);
    }

    public List<Business> findByCategory(BusinessCategory category) {
        return businessRepository.findByCategory(category);
    }

    public Business getById(Long id) {
        return businessRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}

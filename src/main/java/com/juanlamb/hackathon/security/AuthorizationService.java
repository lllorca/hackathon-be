package com.juanlamb.hackathon.security;

import com.juanlamb.hackathon.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    public User getLoggedInUser() {
        return ((JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }
}

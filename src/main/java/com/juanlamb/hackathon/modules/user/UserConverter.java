package com.juanlamb.hackathon.modules.user;

import com.juanlamb.hackathon.domain.User;
import com.juanlamb.hackathon.modules.user.dto.RegisterDto;
import com.juanlamb.hackathon.modules.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final ModelMapper modelMapper;

    public User convert(RegisterDto registerDto) {
        return modelMapper.map(registerDto, User.class);
    }

    public UserDto convert(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}

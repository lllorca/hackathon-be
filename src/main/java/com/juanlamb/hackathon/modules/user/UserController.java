package com.juanlamb.hackathon.modules.user;

import com.juanlamb.hackathon.domain.User;
import com.juanlamb.hackathon.modules.user.dto.RegisterDto;
import com.juanlamb.hackathon.modules.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody RegisterDto registerDto) {
        User userToCreate = userConverter.convert(registerDto);
        User newUser = userService.newUser(userToCreate);
        return userConverter.convert(newUser);
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return userConverter.convert(user);
    }

}

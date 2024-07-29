package by.fenix.lessons.tasklist.web.controller;

import by.fenix.lessons.tasklist.domain.user.User;
import by.fenix.lessons.tasklist.service.AuthService;
import by.fenix.lessons.tasklist.service.UserService;
import by.fenix.lessons.tasklist.web.dto.auth.JwtRequest;
import by.fenix.lessons.tasklist.web.dto.auth.JwtResponse;
import by.fenix.lessons.tasklist.web.dto.user.UserDto;
import by.fenix.lessons.tasklist.web.dto.validation.OnCreate;
import by.fenix.lessons.tasklist.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login (@Validated @RequestBody JwtRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public UserDto register(@Validated (OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh (@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}

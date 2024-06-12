package ru.jdrims.cloudstorage.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.jdrims.cloudstorage.dto.request.LoginRequest;
import ru.jdrims.cloudstorage.dto.response.LoginResponse;
import ru.jdrims.cloudstorage.service.AuthService;

@RestController
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/logout")
    public void logout(@RequestHeader("auth-token") String token) {
        authService.logout(token);
    }
}

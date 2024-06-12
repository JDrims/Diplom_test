package ru.jdrims.cloudstorage.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "login not null")
    private String login;
    @NotBlank(message = "password not null")
    private String password;
}

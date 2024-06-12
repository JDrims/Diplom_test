package ru.jdrims.cloudstorage.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    @JsonProperty("auth-token")
    private String token;
}

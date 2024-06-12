package ru.jdrims.cloudstorage.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.jdrims.cloudstorage.dto.request.LoginRequest;
import ru.jdrims.cloudstorage.dto.response.LoginResponse;
import ru.jdrims.cloudstorage.exception.ErrorException;
import ru.jdrims.cloudstorage.jwt.TokenGenerateUtil;
import ru.jdrims.cloudstorage.model.User;
import ru.jdrims.cloudstorage.repository.AuthRepository;
import ru.jdrims.cloudstorage.repository.UserRepository;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {
    private AuthRepository authRepository;
    private UserRepository userRepository;
    private TokenGenerateUtil tokenGenerateUtil;

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication auth = new UsernamePasswordAuthenticationToken(
                loginRequest.getLogin(),
                loginRequest.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        UserDetails userDetails = loadUserByUsername(loginRequest.getLogin());
        String token = tokenGenerateUtil.generateToken(userDetails);
        authRepository.putTokenAndUsername(token, loginRequest.getLogin());
        log.info("User {} logged with {}", loginRequest.getLogin(), token);
        return new LoginResponse(token);
    }

    public void logout(String token) {
        String username = authRepository.getUsernameByToken(token);
        log.info("User {} logout", username);
    }

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("Auth Service: Unauthorized");
            throw new ErrorException("Auth Service: Unauthorized");
        }
        return user;
    }
}

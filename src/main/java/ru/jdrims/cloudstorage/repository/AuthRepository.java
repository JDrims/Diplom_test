package ru.jdrims.cloudstorage.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AuthRepository {
    private final Map<String, String> listTokenAndUsername = new ConcurrentHashMap<>();

    public void putTokenAndUsername(String token, String username) {
        listTokenAndUsername.put(token, username);
    }

    public void removeTokenAndUsername(String token) {
        listTokenAndUsername.remove(token);
    }

    public String getUsernameByToken(String token) {
        return listTokenAndUsername.get(token);
    }
}

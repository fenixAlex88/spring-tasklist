package by.fenix.lessons.tasklist.service.impl;

import by.fenix.lessons.tasklist.service.AuthService;
import by.fenix.lessons.tasklist.web.dto.auth.JwtRequest;
import by.fenix.lessons.tasklist.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}

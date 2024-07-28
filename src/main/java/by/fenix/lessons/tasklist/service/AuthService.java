package by.fenix.lessons.tasklist.service;

import by.fenix.lessons.tasklist.web.dto.auth.JwtRequest;
import by.fenix.lessons.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login (JwtRequest loginRequest);

    JwtResponse refresh (String refreshToken);
}

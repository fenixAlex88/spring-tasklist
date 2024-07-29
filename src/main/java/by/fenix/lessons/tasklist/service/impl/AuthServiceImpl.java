package by.fenix.lessons.tasklist.service.impl;

import by.fenix.lessons.tasklist.domain.user.User;
import by.fenix.lessons.tasklist.service.AuthService;
import by.fenix.lessons.tasklist.service.UserService;
import by.fenix.lessons.tasklist.web.dto.auth.JwtRequest;
import by.fenix.lessons.tasklist.web.dto.auth.JwtResponse;
import by.fenix.lessons.tasklist.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        User user = userService.getByUserName(loginRequest.getUserName());
        jwtResponse.setId(user.getId());
        jwtResponse.setUserName(user.getUserName());
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getUserName(), user.getRoles()));
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUserName()));
        return jwtResponse;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return jwtTokenProvider.refreshUsersToken(refreshToken);
    }
}

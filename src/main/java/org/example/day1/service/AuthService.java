package org.example.day1.service;

import org.example.day1.domain.entity.User;
import org.example.day1.dto.auth.*;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse refresh(RefreshTokenRequest request);
    void changePassword(String username, ChangePasswordRequest request);
    CurrentUserResponse me(String username);
    User findActiveUserByUsername(String username);
}

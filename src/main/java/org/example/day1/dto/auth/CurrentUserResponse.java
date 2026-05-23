package org.example.day1.dto.auth;

public record CurrentUserResponse(
        Long id,
        String username,
        String fullName,
        String role,
        Long parentId,
        Long teacherId
) {
}

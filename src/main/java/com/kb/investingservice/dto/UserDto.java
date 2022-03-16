package com.kb.investingservice.dto;

import com.kb.investingservice.domain.User;

public record UserDto(
        String userId,
        String name
) {

    public static UserDto isOnly(String userId) {
        return UserDto.of(userId, null);
    }

    public static UserDto of(
            String userId,
            String name
    ) {
        return new UserDto(userId, name);
    }

    public static UserDto of(User user) {
        return new UserDto(
                user.getUserId(),
                user.getName()
        );
    }

}

package org.example.expert.config;

import lombok.Getter;
import org.example.expert.domain.user.enums.UserRole;

@Getter
public class SecurityPrincipal {

    private Long userId;
    private String email;
    private String nickName;
    private UserRole userRole;

    public SecurityPrincipal(Long userId, String email, String nickName, UserRole userRole) {
    }
}



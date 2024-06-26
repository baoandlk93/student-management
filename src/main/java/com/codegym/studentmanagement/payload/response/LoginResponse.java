package com.codegym.studentmanagement.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LoginResponse {
    private String username;
    private String token;
    private String fullName;
    private List<String> roles;
}

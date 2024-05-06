package com.codegym.studentmanagement.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String username;
    private String token;
    private String fullName;
}

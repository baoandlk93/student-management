package com.codegym.studentmanagement.service.impl;

import com.codegym.studentmanagement.payload.request.LoginRequest;
import com.codegym.studentmanagement.payload.response.ResponsePayload;
import com.codegym.studentmanagement.repository.IUserRepository;
import com.codegym.studentmanagement.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponsePayload login(LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(authentication.getPrincipal());
            return ResponsePayload
                    .builder()
                    .message("Login success")
                    .data("token")
                    .status(HttpStatus.OK)
                    .build();
//        String token = JwtUtils
//                .generateToken(authentication);
        } catch (Exception e) {
            return ResponsePayload
                    .builder()
                    .message("Login failed")
                    .data(e.getCause().getMessage())
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        }
    }
}
//        return ResponsePayload.builder()
//                .message("Login failed")
//                .data(null)
//                .status(HttpStatus.UNAUTHORIZED)
//                .build();
//    }


package com.codegym.studentmanagement.controller;

import com.codegym.studentmanagement.payload.request.LoginRequest;
import com.codegym.studentmanagement.payload.response.ResponsePayload;
import com.codegym.studentmanagement.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponsePayload> login(@RequestBody LoginRequest loginRequest) {
        ResponsePayload responsePayload = userService.login(loginRequest);
        return ResponseEntity.ok(responsePayload);
    }
}

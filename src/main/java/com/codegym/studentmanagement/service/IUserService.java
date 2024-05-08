package com.codegym.studentmanagement.service;

import com.codegym.studentmanagement.payload.request.LoginRequest;
import com.codegym.studentmanagement.payload.request.RegisterRequest;
import com.codegym.studentmanagement.payload.response.ResponsePayload;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {
    ResponsePayload login(LoginRequest loginRequest);

    ResponsePayload register(RegisterRequest registerRequest);

    boolean uploadFile(MultipartFile file);
}

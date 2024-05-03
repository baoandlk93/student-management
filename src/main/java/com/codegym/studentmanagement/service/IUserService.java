package com.codegym.studentmanagement.service;

import com.codegym.studentmanagement.payload.request.LoginRequest;
import com.codegym.studentmanagement.payload.response.ResponsePayload;

public interface IUserService {
    ResponsePayload login(LoginRequest loginRequest);
}

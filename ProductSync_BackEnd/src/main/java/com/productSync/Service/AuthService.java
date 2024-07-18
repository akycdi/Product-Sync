package com.productSync.Service;


import com.productSync.DTO.LoginDto;
import com.productSync.DTO.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
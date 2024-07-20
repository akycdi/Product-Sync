package com.productSync;

import com.productSync.Controller.AuthController;
import com.productSync.DTO.JWTAuthResponse;
import com.productSync.DTO.LoginDto;
import com.productSync.DTO.RegisterDto;
import com.productSync.Service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsernameOrEmail("testUser");
        loginDto.setPassword("testPass");

        String mockToken = "mockToken";
        when(authService.login(any(LoginDto.class))).thenReturn(mockToken);

        ResponseEntity<JWTAuthResponse> responseEntity = authController.login(loginDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockToken, responseEntity.getBody().getAccessToken());
    }

    @Test
    public void testRegister() {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername("testUser");
        registerDto.setPassword("testPass");
        registerDto.setEmail("test@example.com");

        String mockResponse = "User registered successfully";
        when(authService.register(any(RegisterDto.class))).thenReturn(mockResponse);

        ResponseEntity<String> responseEntity = authController.register(registerDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }
}

package com.example.primesservice.controller;
import com.example.primesservice.model.Customer;
import com.example.primesservice.service.IAuthenticationService;
import com.example.primesservice.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {

    private final IAuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public AuthenticationController(IAuthenticationService authenticationService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.tokenService= tokenService;
    }

    @PostMapping("/register")
    public Customer register (@RequestBody Customer customer) {
        try {
            return authenticationService.register(customer);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String Login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getUsername(),
                customer.getPassword()));

        return tokenService.generateToken(authentication);
    }
}
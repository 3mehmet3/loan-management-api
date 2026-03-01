package com.loanmanagment.loan_management_api.controller;

import com.loanmanagment.loan_management_api.dto.ApiResponse;
import com.loanmanagment.loan_management_api.dto.LoginRequest;
import com.loanmanagment.loan_management_api.model.User;
import com.loanmanagment.loan_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        Optional<User> user = userService.login(request.getUsername(), request.getPassword());

        if (user.isPresent()) {
            return ResponseEntity.ok(new ApiResponse(true, "Login successful", user.get().getRole()));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse(false, "Invalid credentials", null));
        }
    }
}
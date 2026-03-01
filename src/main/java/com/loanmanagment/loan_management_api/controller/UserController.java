package com.loanmanagment.loan_management_api.controller;

import com.loanmanagment.loan_management_api.dto.ApiResponse;
import com.loanmanagment.loan_management_api.dto.LoginRequest;
import com.loanmanagment.loan_management_api.model.User;
import com.loanmanagment.loan_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addUser(@RequestBody User user) {
        User saved = userService.save(user);
        return ResponseEntity.ok(new ApiResponse(true, "User created", saved));
    }

    @GetMapping("/staff")
    public ResponseEntity<ApiResponse> getStaff() {
        List<User> staff = userService.getByRole("STAFF");
        return ResponseEntity.ok(new ApiResponse(true, "Staff list", staff));
    }

    @GetMapping("/managers")
    public ResponseEntity<ApiResponse> getManagers() {
        List<User> managers = userService.getByRole("MANAGER");
        return ResponseEntity.ok(new ApiResponse(true, "Manager list", managers));
    }
}

package com.loanmanagment.loan_management_api.service;

import com.loanmanagment.loan_management_api.model.User;
import com.loanmanagment.loan_management_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public List<User> getByRole(String role) {
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getRole().equals(role))
                .toList();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
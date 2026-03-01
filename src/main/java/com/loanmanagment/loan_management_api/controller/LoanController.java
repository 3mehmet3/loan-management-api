package com.loanmanagment.loan_management_api.controller;

import com.loanmanagment.loan_management_api.dto.ApiResponse;
import com.loanmanagment.loan_management_api.dto.LoanRequest;
import com.loanmanagment.loan_management_api.model.LoanApplication;
import com.loanmanagment.loan_management_api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<ApiResponse> apply(@RequestBody LoanRequest request) {
        LoanApplication loan = new LoanApplication();
        loan.setFirstName(request.getFirstName());
        loan.setLastName(request.getLastName());
        loan.setOccupation(request.getOccupation());
        loan.setAnnualIncome(request.getAnnualIncome());
        loan.setLoanType(request.getLoanType());
        loan.setTerm(request.getTerm());
        loan.setInterestRate(request.getInterestRate());

        LoanApplication saved = loanService.apply(loan);
        return ResponseEntity.ok(new ApiResponse(true, "Loan application submitted", saved));
    }

    @GetMapping("/pending")
    public ResponseEntity<ApiResponse> getPending() {
        List<LoanApplication> loans = loanService.getPending();
        return ResponseEntity.ok(new ApiResponse(true, "Pending loans", loans));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll() {
        List<LoanApplication> loans = loanService.getAll();
        return ResponseEntity.ok(new ApiResponse(true, "All loans", loans));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<ApiResponse> approve(@PathVariable Long id) {
        Optional<LoanApplication> loan = loanService.approve(id);
        if (loan.isPresent()) {
            return ResponseEntity.ok(new ApiResponse(true, "Loan approved", loan.get()));
        }
        return ResponseEntity.status(404).body(new ApiResponse(false, "Loan not found", null));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<ApiResponse> reject(@PathVariable Long id) {
        Optional<LoanApplication> loan = loanService.reject(id);
        if (loan.isPresent()) {
            return ResponseEntity.ok(new ApiResponse(true, "Loan rejected", loan.get()));
        }
        return ResponseEntity.status(404).body(new ApiResponse(false, "Loan not found", null));
    }
}
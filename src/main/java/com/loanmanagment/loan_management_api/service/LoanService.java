package com.loanmanagment.loan_management_api.service;

import com.loanmanagment.loan_management_api.model.LoanApplication;
import com.loanmanagment.loan_management_api.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public LoanApplication apply(LoanApplication loan) {
        return loanRepository.save(loan);
    }

    public List<LoanApplication> getPending() {
        return loanRepository.findByStatus("PENDING");
    }

    public List<LoanApplication> getAll() {
        return loanRepository.findAll();
    }

    public Optional<LoanApplication> approve(Long id) {
        Optional<LoanApplication> loan = loanRepository.findById(id);
        loan.ifPresent(l -> {
            l.setStatus("APPROVED");
            loanRepository.save(l);
        });
        return loan;
    }

    public Optional<LoanApplication> reject(Long id) {
        Optional<LoanApplication> loan = loanRepository.findById(id);
        loan.ifPresent(l -> {
            l.setStatus("REJECTED");
            loanRepository.save(l);
        });
        return loan;
    }
}
package com.loanmanagment.loan_management_api.repository;

import com.loanmanagment.loan_management_api.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanApplication, Long> {
    List<LoanApplication> findByStatus(String status);
}
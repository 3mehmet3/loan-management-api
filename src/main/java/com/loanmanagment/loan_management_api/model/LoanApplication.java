package com.loanmanagment.loan_management_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String occupation;
    private String annualIncome;
    private String loanType;
    private String term;
    private String interestRate;
    private String status = "PENDING";
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getOccupation() { return occupation; }
    public String getAnnualIncome() { return annualIncome; }
    public String getLoanType() { return loanType; }
    public String getTerm() { return term; }
    public String getInterestRate() { return interestRate; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public void setAnnualIncome(String annualIncome) { this.annualIncome = annualIncome; }
    public void setLoanType(String loanType) { this.loanType = loanType; }
    public void setTerm(String term) { this.term = term; }
    public void setInterestRate(String interestRate) { this.interestRate = interestRate; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
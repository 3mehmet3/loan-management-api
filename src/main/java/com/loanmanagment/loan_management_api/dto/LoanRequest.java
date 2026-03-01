package com.loanmanagment.loan_management_api.dto;

public class LoanRequest {
    private String firstName;
    private String lastName;
    private String occupation;
    private String annualIncome;
    private String loanType;
    private String term;
    private String interestRate;

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getOccupation() { return occupation; }
    public String getAnnualIncome() { return annualIncome; }
    public String getLoanType() { return loanType; }
    public String getTerm() { return term; }
    public String getInterestRate() { return interestRate; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public void setAnnualIncome(String annualIncome) { this.annualIncome = annualIncome; }
    public void setLoanType(String loanType) { this.loanType = loanType; }
    public void setTerm(String term) { this.term = term; }
    public void setInterestRate(String interestRate) { this.interestRate = interestRate; }
}
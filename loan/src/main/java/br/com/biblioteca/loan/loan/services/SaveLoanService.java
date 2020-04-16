package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.Loan;

@FunctionalInterface
public interface SaveLoanService {

    void insert(Loan obj);

}

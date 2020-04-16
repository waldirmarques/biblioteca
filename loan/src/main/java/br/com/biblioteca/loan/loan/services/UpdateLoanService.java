package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.Loan;

@FunctionalInterface
public interface UpdateLoanService {

    void update(Loan loan, Long id);
}

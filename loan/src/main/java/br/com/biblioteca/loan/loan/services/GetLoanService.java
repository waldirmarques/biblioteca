package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.Loan;

@FunctionalInterface
public interface GetLoanService {

    Loan find(Long id);
}

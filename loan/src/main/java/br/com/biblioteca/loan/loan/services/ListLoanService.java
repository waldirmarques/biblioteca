package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.Loan;

import java.util.List;

@FunctionalInterface
public interface ListLoanService {

    List<Loan> findAll();
}

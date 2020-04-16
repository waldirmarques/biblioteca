package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.Loan;
import org.springframework.data.domain.Page;

@FunctionalInterface
public interface ListPageLoanService {

    Page<Loan> findPage(Integer page, Integer size);
}

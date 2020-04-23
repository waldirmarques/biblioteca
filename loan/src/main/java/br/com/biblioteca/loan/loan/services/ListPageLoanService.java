package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.LoanReturnDTO;
import org.springframework.data.domain.Page;

@FunctionalInterface
public interface ListPageLoanService {

    Page<LoanReturnDTO> findPage(Integer page, Integer size);
}

package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListPageLoanServiceImpl implements ListPageLoanService {

    private final LoanRepository loanRepository;

    @Override
    public Page<Loan> findPage(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"id");
        return loanRepository.findAll(pageRequest);
    }
}

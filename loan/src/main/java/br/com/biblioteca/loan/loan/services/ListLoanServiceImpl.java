package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListLoanServiceImpl implements ListLoanService {

    private final LoanRepository loanRepository;

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }
}

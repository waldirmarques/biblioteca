package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveLoanServiceImpl implements SaveLoanService {

    private final LoanRepository loanRepository;

    @Override
    public void insert(Loan obj) {
        loanRepository.save(obj);
    }
}

package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.exceptions.LoanNotFoundException;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetLoanServiceImpl implements GetLoanService {

    private final LoanRepository loanRepository;

    @Override
    public Loan find(Long id) {
        return loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);
    }
}

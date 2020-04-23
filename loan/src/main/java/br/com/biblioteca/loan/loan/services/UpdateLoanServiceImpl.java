package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.exceptions.BookNotFoundException;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateLoanServiceImpl implements UpdateLoanService {

    private final LoanRepository loanRepository;

    @Override
    public void update(Loan obj, Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(BookNotFoundException::new);
        loan.setLoanTime(obj.getLoanTime());
        loanRepository.save(loan);
    }
}

package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.exceptions.LoanNotFoundException;
import br.com.biblioteca.loan.feign.GetBook;
import br.com.biblioteca.loan.feign.GetUserApp;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import br.com.biblioteca.loan.loan.LoanReturnDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetLoanServiceImpl implements GetLoanService {

    private final LoanRepository loanRepository;
    private final GetBook getBook;
    private final GetUserApp getUserApp;

    @Override
    public LoanReturnDTO find(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);
        return LoanReturnDTO.from(loan, getUserApp.userId(loan.getUserApp()), getBook.bookId(loan.getBook()));
    }
}

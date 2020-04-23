package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.exceptions.BookNotFoundException;
import br.com.biblioteca.loan.exceptions.UserAppNotFoundException;
import br.com.biblioteca.loan.feign.GetBook;
import br.com.biblioteca.loan.feign.GetUserApp;
import br.com.biblioteca.loan.feign.UpdateBook;
import br.com.biblioteca.loan.feign.UpdateUserApp;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveLoanServiceImpl implements SaveLoanService {

    private final LoanRepository loanRepository;
    private final GetBook getBook;
    private final GetUserApp getUserApp;
    private final UpdateUserApp updateUserApp;
    private final UpdateBook updateBook;

    @Override
    public void insert(Loan loan) {
        try {
            updateUserApp.updateUserApp(loan.getUserApp(), getUserApp.userId(loan.getUserApp()));
        } catch (Exception e) {
            throw new UserAppNotFoundException();
        }

        try {
            updateBook.updateBook(loan.getBook(), getBook.bookId(loan.getBook()));
        } catch (Exception e) {
            throw new BookNotFoundException();
        }

        loanRepository.save(loan);
        loan.setLoanSpecificID(gerarSpecificId(loan.getId()));
        loanRepository.save(loan);

    }

    public static String gerarSpecificId(Long id) {
        return "00" + id;
    }
}

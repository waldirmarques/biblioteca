package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.exceptions.BookNotFoundException;
import br.com.biblioteca.loan.exceptions.UserAppNotFoundException;
import br.com.biblioteca.loan.feign.GetBook;
import br.com.biblioteca.loan.feign.GetUserApp;
import br.com.biblioteca.loan.feign.UpdateBook;
import br.com.biblioteca.loan.feign.UpdateUserApp;
import br.com.biblioteca.loan.loan.BookDTO;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import br.com.biblioteca.loan.loan.UserAppDTO;
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
            getUserApp.userId(loan.getUserApp());
        } catch (Exception e) {
            throw new UserAppNotFoundException();
        }

        try {
            getBook.bookId(loan.getBook());
        } catch (Exception e) {
            throw new BookNotFoundException();
        }

        loanRepository.save(loan);
        loan.setLoanSpecificID(gerarSpecificId(loan.getId()));
        loanRepository.save(loan);

        UserAppDTO userAppDTO = getUserApp.userId(loan.getUserApp());
        userAppDTO.setLoanSpecificID(loan.getLoanSpecificID());
        updateUserApp.updateUserApp(loan.getUserApp(), userAppDTO);
        BookDTO bookDTO = getBook.bookId(loan.getBook());
        bookDTO.setLoanSpecificID(loan.getLoanSpecificID());
        updateBook.updateBook(loan.getBook(), bookDTO);
    }

    public static String gerarSpecificId(Long id) {
        return "00" + id;
    }
}

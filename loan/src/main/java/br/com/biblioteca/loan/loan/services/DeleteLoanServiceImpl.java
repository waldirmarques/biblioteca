package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.exceptions.LoanNotDeletedException;
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
public class DeleteLoanServiceImpl implements DeleteLoanService {

    private final LoanRepository loanRepository;
    private final GetUserApp getUserApp;
    private final UpdateUserApp updateUserApp;
    private final GetBook getBook;
    private final UpdateBook updateBook;

    @Override
    public void delete(Long id) {

        if (!loanRepository.existsById(id)) {
            throw new LoanNotDeletedException();
        }

        Loan loan = loanRepository.findById(id).get();
        UserAppDTO userAppDTO = getUserApp.userId(loan.getUserApp());
        userAppDTO.setLoanSpecificID(null);
        updateUserApp.updateUserApp(loan.getUserApp(), userAppDTO);
        BookDTO bookDTO = getBook.bookId(loan.getBook());
        bookDTO.setLoanSpecificID(null);
        updateBook.updateBook(loan.getBook(), bookDTO);

        loanRepository.deleteById(id);
    }
}

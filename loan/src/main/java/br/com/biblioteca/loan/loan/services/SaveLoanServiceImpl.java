package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.exceptions.BookNotFoundException;
import br.com.biblioteca.loan.exceptions.UserAppNotFoundException;
import br.com.biblioteca.loan.feign.GetBook;
import br.com.biblioteca.loan.feign.GetUserApp;
import br.com.biblioteca.loan.feign.UpdateBook;
import br.com.biblioteca.loan.feign.UpdateUserApp;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanBookSpecificIdDTO;
import br.com.biblioteca.loan.loan.LoanRepository;
import br.com.biblioteca.loan.loan.LoanUserAppSpecificIdDTO;
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
    private LoanUserAppSpecificIdDTO loanUserAppSpecificIdDTO = new LoanUserAppSpecificIdDTO();
    private LoanBookSpecificIdDTO loanBookSpecificIdDTO = new LoanBookSpecificIdDTO();

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

        loanUserAppSpecificIdDTO.setLoanSpecificID(loan.getLoanSpecificID());
        loanBookSpecificIdDTO.setLoanSpecificID(loan.getLoanSpecificID());
        updateUserApp.updateUserApp(loan.getUserApp(), loanUserAppSpecificIdDTO);
        updateBook.updateBook(loan.getBook(), loanBookSpecificIdDTO);
    }

    public static String gerarSpecificId(Long id) {
        return "00" + id;
    }
}

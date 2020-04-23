package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.feign.GetBook;
import br.com.biblioteca.loan.feign.GetUserApp;
import br.com.biblioteca.loan.loan.BookDTO;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import br.com.biblioteca.loan.loan.LoanReturnDTO;
import br.com.biblioteca.loan.loan.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ListLoanServiceImpl implements ListLoanService {

    private final LoanRepository loanRepository;
    private List<LoanReturnDTO> loans;
    private LoanReturnDTO loanReturnDTO;
    private final GetBook getBook;
    private final GetUserApp getUserApp;

    @Override
    public List<LoanReturnDTO> findAll() {
        loans = new ArrayList<>();
        loanReturnDTO = new LoanReturnDTO();
        for (Loan loan: loanRepository.findAll()){
            UserDTO userDTO = getUserApp.userId(loan.getUserApp());
            BookDTO bookDTO = getBook.bookId(loan.getBook());
            loans.add(loanReturnDTO.from(loan, userDTO, bookDTO));
        }
        return loans;
    }
}

package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.feign.GetBook;
import br.com.biblioteca.loan.feign.GetUserApp;
import br.com.biblioteca.loan.loan.BookDTO;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import br.com.biblioteca.loan.loan.LoanReturnDTO;
import br.com.biblioteca.loan.loan.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ListPageLoanServiceImpl implements ListPageLoanService {

    private final LoanRepository loanRepository;
    private List<LoanReturnDTO> loans;
    private LoanReturnDTO loanReturnDTO;
    private final GetBook getBook;
    private final GetUserApp getUserApp;

    @Override
    public Page<LoanReturnDTO> findPage(Integer page, Integer size) {
        loans = new ArrayList<>();
        loanReturnDTO = new LoanReturnDTO();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"id");
        for (Loan loan: loanRepository.findAll(pageRequest)){
            UserDTO userDTO = getUserApp.userId(loan.getUserApp());
            BookDTO bookDTO = getBook.bookId(loan.getBook());
            loans.add(loanReturnDTO.from(loan, userDTO, bookDTO));
        }
        return (Page<LoanReturnDTO>) loans;
    }
}

package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.feign.GetBook;
import br.com.biblioteca.loan.feign.GetUserApp;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanDTO;
import br.com.biblioteca.loan.loan.LoanRepository;
import br.com.biblioteca.loan.loan.LoanReturnDTO;
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
    private final GetBook getBook;
    private final GetUserApp getUserApp;

    @Override
    public Page<LoanReturnDTO> findPage(Integer page, Integer size) {
        loans = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        for (Loan loan : loanRepository.findAll(pageRequest)) {
            loans.add(LoanReturnDTO.from(loan, getUserApp.userId(loan.getUserApp()), getBook.bookId(loan.getBook())));
        }
        return loans.stream().map(LoanDTO::from);;
    }
}

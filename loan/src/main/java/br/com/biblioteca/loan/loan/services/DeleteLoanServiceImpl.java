package br.com.biblioteca.loan.loan.services;

import br.com.biblioteca.loan.exceptions.LoanNotDeletedException;
import br.com.biblioteca.loan.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteLoanServiceImpl implements DeleteLoanService {
    private final LoanRepository loanRepository;

    @Override
    public void delete(Long id) {

        if (!loanRepository.existsById(id)) {
            throw new LoanNotDeletedException();
        }
        loanRepository.deleteById(id);
    }
}

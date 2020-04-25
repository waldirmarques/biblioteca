package br.com.biblioteca.loan;

import br.com.biblioteca.loan.feign.GetBook;
import br.com.biblioteca.loan.feign.GetUserApp;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanRepository;
import br.com.biblioteca.loan.loan.LoanReturnDTO;
import br.com.biblioteca.loan.loan.services.ListLoanServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.biblioteca.loan.builders.LoanBuilder.createLoan;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Valida funcionalidade do serviço responsável por pesquisar todos os Loan")
public class ListLoanServiceTest {

    @Mock
    private LoanRepository loanRepository;
    private ListLoanServiceImpl findAllLoan;
    private GetBook getBook;
    private GetUserApp getUserApp;

    @BeforeEach
    public void setUp() {
        this.findAllLoan = new ListLoanServiceImpl(loanRepository, getBook, getUserApp);
    }

    @Test
    @DisplayName("Deve retornar todos os emprestimos")
    void shouldFindAllLoan() {

        when(loanRepository.findAll()).thenReturn(
                Stream.of(createLoan().loanTime("50 dias").build(),
                        createLoan().loanTime("60 dias").build(),
                        createLoan().loanTime("35 dias").build()).collect(Collectors.toList())
        );

        List<LoanReturnDTO> result = this.findAllLoan.findAll();

        assertAll("Loan",
                () -> assertThat(result.size(), is(3)),
                () -> assertThat(result.get(0).getLoanTime(), is("50 dias")),
                () -> assertThat(result.get(1).getLoanTime(), is("60 dias")),
                () -> assertThat(result.get(2).getLoanTime(), is("35 dias"))
        );
    }
}

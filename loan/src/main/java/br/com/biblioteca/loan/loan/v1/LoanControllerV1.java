package br.com.biblioteca.loan.loan.v1;

import br.com.biblioteca.loan.feign.ConsultaBook;
import br.com.biblioteca.loan.feign.ConsultaUserApp;
import br.com.biblioteca.loan.loan.BookDTO;
import br.com.biblioteca.loan.loan.Loan;
import br.com.biblioteca.loan.loan.LoanDTO;
import br.com.biblioteca.loan.loan.services.DeleteLoanService;
import br.com.biblioteca.loan.loan.services.GetLoanService;
import br.com.biblioteca.loan.loan.services.ListLoanService;
import br.com.biblioteca.loan.loan.services.ListPageLoanService;
import br.com.biblioteca.loan.loan.services.SaveLoanService;
import br.com.biblioteca.loan.loan.services.UpdateLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api/loan")
public class LoanControllerV1 {

    @Autowired
    private ConsultaBook consultaBook;
    @Autowired
    private ConsultaUserApp consultaUserApp;

    private final GetLoanService getLoanService;
    private final ListLoanService listLoanService;
    private final ListPageLoanService listPageLoanService;
    private final SaveLoanService saveLoanService;
    private final UpdateLoanService updateLoanService;
    private final DeleteLoanService deleteLoanService;


    @GetMapping(value = "testando/{id}") //lista emprestimos por id
    public BookDTO findBook(@PathVariable Long id) {
        return consultaBook.bookId(id);
    }

    @GetMapping(value = "/{id}") //lista emprestimos por id
    public LoanDTO find(@PathVariable Long id) {
        return LoanDTO.from(getLoanService.find(id));
    }

    @GetMapping //lista todos os emprestimos
    public List<LoanDTO> findAll() {
        return LoanDTO.fromAll(listLoanService.findAll());
    }

    @GetMapping(params = {"page", "size"}) //lista todas os emprestimos com paginação
    public Page<LoanDTO> findPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return LoanDTO.fromPage(listPageLoanService.findPage(page, size));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping() //adiciona um emprestimo Book
    public void insert(@Valid @RequestBody LoanDTO loanDTO) {
        saveLoanService.insert(Loan.to(loanDTO));
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}") //atualizar uma emprestimo
    public void update(@Valid @RequestBody LoanDTO loanDTO, @PathVariable Long id) {
        updateLoanService.update(Loan.to(loanDTO), id);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}") //Deleta emprestimo
    public void delete(@PathVariable Long id) {
        deleteLoanService.delete(id);
    }
}

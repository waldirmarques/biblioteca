package br.com.biblioteca.loan.loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class LoanDTO {

    private Long id;

    @NotNull
    private UserApp userApp;

    @NotEmpty
    private List<Book> books;

    @NotEmpty
    private String loanTime;

    public static LoanDTO from(Loan loan) {
        return LoanDTO
                .builder()
                .id(loan.getId())
                .userApp(loan.getUserApp())
                .books(loan.getBooks())
                .loanTime(loan.getLoanTime())
                .build();

    }

    public static List<LoanDTO> fromAll(List<Loan> userApps) {
        return userApps.stream().map(LoanDTO::from).collect(Collectors.toList());
    }

    public static Page<LoanDTO> fromPage(Page<Loan> pages) {
        return pages.map(LoanDTO::from);
    }

}

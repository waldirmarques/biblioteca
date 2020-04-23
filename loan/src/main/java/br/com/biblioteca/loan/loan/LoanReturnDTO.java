package br.com.biblioteca.loan.loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class LoanReturnDTO {

    private Long id;

    @NotEmpty
    private UserAppDTO userApp;

    @NotEmpty
    private BookDTO book;

    @NotEmpty
    private String loanTime;

    public static LoanReturnDTO from(Loan loan, UserAppDTO userAppDTO, BookDTO bookDTO) {
        return LoanReturnDTO
                .builder()
                .id(loan.getId())
                .userApp(userAppDTO)
                .book(bookDTO)
                .loanTime(loan.getLoanTime())
                .build();
    }

    public static List<LoanDTO> fromAll(List<Loan> userApps) {
        return userApps.stream().map(LoanDTO::from).collect(Collectors.toList());
    }
}

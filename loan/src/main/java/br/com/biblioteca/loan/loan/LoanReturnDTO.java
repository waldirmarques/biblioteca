package br.com.biblioteca.loan.loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class LoanReturnDTO {

    private Long id;

    @NotEmpty
    private UserDTO userApp;

    @NotEmpty
    private BookDTO book;

    @NotEmpty
    private String loanTime;

    public static LoanReturnDTO from(Loan loan, UserDTO userDTO, BookDTO bookDTO) {
        return LoanReturnDTO
                .builder()
                .id(loan.getId())
                .userApp(userDTO)
                .book(bookDTO)
                .loanTime(loan.getLoanTime())
                .build();
    }
}

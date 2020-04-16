package br.com.biblioteca.loan.loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
public class Loan implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "userApp_id")
   // private UserApp userApp;

    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
   // @JoinTable(name = "LOAN_BOOK",
   //         joinColumns = @JoinColumn(name = "book_id"),
   //         inverseJoinColumns = @JoinColumn(name = "loan_id")
   // )
    //private List<Book> books = new ArrayList<>();

    private String loanTime;

    public static Loan to(br.com.biblioteca.loan.loan.LoanDTO loanDTO) {
        return Loan
                .builder()
                .id(loanDTO.getId())
                //.userApp(loanDTO.getUserApp())
                //.books(loanDTO.getBooks())
                .loanTime(loanDTO.getLoanTime())
                .build();
    }
}

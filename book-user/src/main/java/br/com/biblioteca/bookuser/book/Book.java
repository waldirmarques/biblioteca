package br.com.biblioteca.bookuser.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder(builderClassName = "Builder")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specificID;

    private String title; //titulo

    private String resume; //resumo

    private String isbn;

    private String author; //autor

    private Date yearBook; //ano

    //@JsonIgnore
    //    //@ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    //    //private List<Loan> loan = new ArrayList<>();

    public Book(String title, String resume, String isbn, String author) {
        this.title = title;
        this.resume = resume;
        this.isbn = isbn;
        this.author = author;
    }

    public static Book to(br.com.biblioteca.bookuser.book.BookDTO bookDTO) {
        return Book
                .builder()
                .id(bookDTO.getId())
                .title(bookDTO.getTitle())
                .resume(bookDTO.getResume())
                .isbn(bookDTO.getIsbn())
                .author(bookDTO.getAuthor())
                .yearBook(bookDTO.getYearBook())
                .build();
    }
}

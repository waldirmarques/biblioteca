package br.com.biblioteca.bookuser.book.services;

import br.com.biblioteca.bookuser.book.Book;
import br.com.biblioteca.bookuser.book.BookRepository;
import br.com.biblioteca.bookuser.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateBookSpecificIdLoanImpl implements UpdateBookSpecificIdLoan {

    private final BookRepository bookRepository;

    @Override
    public void updateSpecificId(Book book, String id) {
        Book bookApp = bookRepository.findBySpecificID(id).orElseThrow(BookNotFoundException::new);

        bookApp.setTitle(book.getTitle());
        bookApp.setResume(book.getResume());
        bookApp.setIsbn(book.getIsbn());
        bookApp.setAuthor(book.getAuthor());
        bookApp.setYearBook(book.getYearBook());
        bookApp.setLoanSpecificID(book.getLoanSpecificID());
        bookRepository.save(bookApp);
    }
}

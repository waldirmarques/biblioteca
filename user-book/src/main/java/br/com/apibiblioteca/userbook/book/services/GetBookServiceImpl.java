package br.com.apibiblioteca.userbook.book.services;

import br.com.apibiblioteca.userbook.book.Book;
import br.com.apibiblioteca.userbook.book.BookRepository;
import br.com.apibiblioteca.userbook.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetBookServiceImpl implements GetBookService {

    private final BookRepository bookRepository;

    public Book find(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

}

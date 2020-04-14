package br.com.apibiblioteca.userbook.book.services;

import br.com.apibiblioteca.userbook.book.Book;
import br.com.apibiblioteca.userbook.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveBookServiceImpl implements SaveBookService {

    private final BookRepository bookRepository;

    @Override
    public void insert(Book book) {
        bookRepository.save(book);
    }
}

package br.com.apibiblioteca.userbook.book.services;

import br.com.apibiblioteca.userbook.book.Book;
import br.com.apibiblioteca.userbook.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListBookServiceImpl implements ListBookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}

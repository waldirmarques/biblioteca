package br.com.apibiblioteca.userbook.book.services;

import br.com.apibiblioteca.userbook.book.BookRepository;
import br.com.apibiblioteca.userbook.exceptions.BookNotDeletedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteBookServiceImpl implements DeleteBookService {

    private final BookRepository bookRepository;

    @Override
    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotDeletedException();
        }
        bookRepository.deleteById(id);
    }
}

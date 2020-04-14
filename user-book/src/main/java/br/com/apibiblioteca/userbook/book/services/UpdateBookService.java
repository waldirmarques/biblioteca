package br.com.apibiblioteca.userbook.book.services;

import br.com.apibiblioteca.userbook.book.Book;

@FunctionalInterface
public interface UpdateBookService {

    void update(Book book, Long id);
}

package br.com.biblioteca.bookuser.book.services;

import br.com.biblioteca.bookuser.book.Book;

@FunctionalInterface
public interface UpdateBookSpecificIdLoan {

    void updateSpecificId(Book book, String id);
}

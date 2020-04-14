package br.com.apibiblioteca.userbook.book.services;

import br.com.apibiblioteca.userbook.book.Book;

import java.util.List;

@FunctionalInterface
public interface ListBookService {

    List<Book> findAll();

}

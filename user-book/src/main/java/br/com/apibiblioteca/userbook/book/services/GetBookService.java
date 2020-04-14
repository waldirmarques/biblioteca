package br.com.apibiblioteca.userbook.book.services;


import br.com.apibiblioteca.userbook.book.Book;

@FunctionalInterface
public interface GetBookService {

    Book find(Long id);

}

package br.com.apibiblioteca.userbook.book.services;

@FunctionalInterface
public interface DeleteBookService {

    void delete(Long id);
}

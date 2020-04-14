package br.com.apibiblioteca.userbook.book.services;

import br.com.apibiblioteca.userbook.book.Book;
import org.springframework.data.domain.Page;

@FunctionalInterface
public interface ListPageBookService {

    Page<Book> findPage(Integer page, Integer size);
}

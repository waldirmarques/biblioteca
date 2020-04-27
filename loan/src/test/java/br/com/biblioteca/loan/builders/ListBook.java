package br.com.biblioteca.loan.builders;

import br.com.biblioteca.loan.loan.BookDTO;

import java.util.ArrayList;
import java.util.List;

import static br.com.biblioteca.loan.builders.BookBuilder.createBook;

public class ListBook {

    public static List<BookDTO> listBook(){
        List<BookDTO> bookBuilders = new ArrayList<>();
        bookBuilders.add(createBook().id(1L).build());
        bookBuilders.add(createBook().id(2L).build());
        return bookBuilders;
    }
}

package br.com.apibiblioteca.userbook.book.builders;

import br.com.apibiblioteca.userbook.book.Book;

public class BookBuilder {

    public static Book.Builder createBook() {
        return Book
                .builder()
                .author("teste author")
                .resume("teste resume")
                .isbn("teste isbn")
                .title("teste title");
    }

}

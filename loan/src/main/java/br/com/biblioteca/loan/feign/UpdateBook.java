package br.com.biblioteca.loan.feign;

import br.com.biblioteca.loan.loan.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(contextId = "UpdateBook", url = "http://localhost:9092/v2/api/book", name = "book-user")
public interface UpdateBook {

    @PutMapping(value = "/{book}")
    void updateBook(@PathVariable("book") String id, BookDTO bookDTO);
}

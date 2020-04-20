package br.com.biblioteca.bookuser.book.v1;

import br.com.biblioteca.bookuser.book.BookDTO;
import br.com.biblioteca.bookuser.book.services.GetSpecificIdBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/api/book")
public class BookControllerV2 {

    private final GetSpecificIdBookService getSpecificIdBookService;

    @GetMapping(value = "/{id}") //lista usuário por id
    public BookDTO find(@PathVariable String id) {
        return BookDTO.from(getSpecificIdBookService.findBySpecificID(id));
    }

}

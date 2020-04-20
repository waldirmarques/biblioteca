package br.com.biblioteca.loan.feign;

import br.com.biblioteca.loan.loan.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "fooUserApp", url = "http://localhost:9092/v1/api/user", name = "book-user")
public interface ConsultaUserApp {

    @GetMapping(value = "/{id}")
    UserDTO bookId (@PathVariable Long id);
}

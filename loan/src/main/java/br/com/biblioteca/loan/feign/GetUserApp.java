package br.com.biblioteca.loan.feign;

import br.com.biblioteca.loan.loan.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "GetUserApp", url = "http://localhost:9092/v2/api/user", name = "book-user")
public interface GetUserApp {

    @GetMapping(value = "/{id}")
    UserDTO userId (@PathVariable String id);
}

package br.com.biblioteca.loan.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(contextId = "UpdateUserApp", url = "http://localhost:9092/v2/api/user", name = "book-user")
public interface UpdateUserApp {

    @PutMapping
    void updateUserApp(String userApp, String loanSpecificID);
}

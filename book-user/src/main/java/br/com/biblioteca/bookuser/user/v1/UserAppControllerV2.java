package br.com.biblioteca.bookuser.user.v1;

import br.com.biblioteca.bookuser.user.UserAppDTO;
import br.com.biblioteca.bookuser.user.services.GetSpecificIdUserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/api/user")
public class UserAppControllerV2 {

    private final GetSpecificIdUserAppService getSpecificIdUserAppService;

    @GetMapping(value = "/{id}")
    public UserAppDTO find(@PathVariable String id) {
        return UserAppDTO.from(getSpecificIdUserAppService.findBySpecificID(id));
    }

}

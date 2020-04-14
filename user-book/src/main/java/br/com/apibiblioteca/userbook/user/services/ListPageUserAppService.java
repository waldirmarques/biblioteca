package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.user.UserApp;
import org.springframework.data.domain.Page;

@FunctionalInterface
public interface ListPageUserAppService {

    Page<UserApp> findPage(Integer page, Integer size);
}

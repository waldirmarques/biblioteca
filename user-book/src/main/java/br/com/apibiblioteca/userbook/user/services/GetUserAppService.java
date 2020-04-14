package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.user.UserApp;

@FunctionalInterface
public interface GetUserAppService {

    UserApp find(Long id);
}

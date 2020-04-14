package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.user.UserApp;

@FunctionalInterface
public interface UpdateUserAppService {

    void update(UserApp userApp, Long id);
}

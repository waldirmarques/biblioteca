package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.user.UserApp;

@FunctionalInterface
public interface SaveUserAppService {

    void insert(UserApp userApp);
}

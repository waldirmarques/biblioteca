package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.user.UserApp;

import java.util.List;

@FunctionalInterface
public interface ListUserAppService {

    List<UserApp> findAll();
}

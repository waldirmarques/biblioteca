package br.com.biblioteca.bookuser.user.services;

import br.com.biblioteca.bookuser.user.UserApp;

@FunctionalInterface
public interface UpdateUserAppSpecificIdLoan {

    void update(UserApp userApp, String id);
}

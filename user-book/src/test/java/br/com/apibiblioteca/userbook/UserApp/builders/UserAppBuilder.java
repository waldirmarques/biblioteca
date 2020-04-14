package br.com.apibiblioteca.userbook.UserApp.builders;

import br.com.apibiblioteca.userbook.user.UserApp;

public class UserAppBuilder {

    public static UserApp.Builder createUserApp(){
        return UserApp
                .builder()
                .name("teste nome")
                .age(20)
                .fone("teste fone");
    }
}

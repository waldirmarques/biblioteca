package br.com.biblioteca.bookuser.user.services;

import br.com.biblioteca.bookuser.exceptions.UserAppNotFoundException;
import br.com.biblioteca.bookuser.user.UserApp;
import br.com.biblioteca.bookuser.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateUserAppSpecificIdLoanImpl implements UpdateUserAppSpecificIdLoan {

    private final UserAppRepository userAppRepository;

    @Override
    public void update(UserApp userApp, String id) {
        UserApp user = userAppRepository.findBySpecificID(id).orElseThrow(UserAppNotFoundException::new);

        user.setName(user.getName());
        user.setAge(user.getAge());
        user.setFone(user.getFone());
        user.setLoanSpecificID(userApp.getLoanSpecificID());
        userAppRepository.save(user);
    }
}

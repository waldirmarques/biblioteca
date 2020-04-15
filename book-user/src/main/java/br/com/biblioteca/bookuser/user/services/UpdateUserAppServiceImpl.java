package br.com.biblioteca.bookuser.user.services;

import br.com.biblioteca.bookuser.exceptions.UserAppNotFoundException;
import br.com.biblioteca.bookuser.user.UserApp;
import br.com.biblioteca.bookuser.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateUserAppServiceImpl implements UpdateUserAppService {

    private final UserAppRepository userAppRepository;

    @Override
    public void update(UserApp obj, Long id) {
        UserApp userApp = userAppRepository.findById(id).orElseThrow(UserAppNotFoundException::new);

        userApp.setName(obj.getName());
        userApp.setAge(obj.getAge());
        userApp.setFone(obj.getFone());
        userAppRepository.save(userApp);
    }
}

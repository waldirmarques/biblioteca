package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.exceptions.UserAppNotFoundException;
import br.com.apibiblioteca.userbook.user.UserApp;
import br.com.apibiblioteca.userbook.user.UserAppRepository;
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

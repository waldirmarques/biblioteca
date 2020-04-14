package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.user.UserApp;
import br.com.apibiblioteca.userbook.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveUserAppServiceImpl implements SaveUserAppService {

    private final UserAppRepository userAppRepository;

    @Override
    public void insert(UserApp obj) {
        userAppRepository.save(obj);
    }
}

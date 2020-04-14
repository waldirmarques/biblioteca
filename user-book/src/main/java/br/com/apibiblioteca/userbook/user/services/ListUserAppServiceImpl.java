package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.user.UserApp;
import br.com.apibiblioteca.userbook.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListUserAppServiceImpl implements ListUserAppService {

    private final UserAppRepository userAppRepository;

    @Override
    public List<UserApp> findAll() {
        return userAppRepository.findAll();
    }
}

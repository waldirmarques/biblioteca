package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.exceptions.UserAppNotFoundException;
import br.com.apibiblioteca.userbook.user.UserApp;
import br.com.apibiblioteca.userbook.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserAppServiceImpl implements GetUserAppService {

    private final UserAppRepository userAppRepository;

    @Override
    public UserApp find(Long id) {
        return userAppRepository.findById(id).orElseThrow(UserAppNotFoundException::new);
    }
}

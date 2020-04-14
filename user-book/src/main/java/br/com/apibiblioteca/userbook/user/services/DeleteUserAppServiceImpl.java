package br.com.apibiblioteca.userbook.user.services;

import br.com.apibiblioteca.userbook.exceptions.UserAppNotDeletedException;
import br.com.apibiblioteca.userbook.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteUserAppServiceImpl implements DeleteUserAppService {

    private final UserAppRepository userAppRepository;

    @Override
    public void delete(Long id) {
        if (!userAppRepository.existsById(id)) {
            throw new UserAppNotDeletedException();
        }
        userAppRepository.deleteById(id);
    }
}

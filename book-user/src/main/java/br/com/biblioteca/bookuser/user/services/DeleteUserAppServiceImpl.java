package br.com.biblioteca.bookuser.user.services;

import br.com.biblioteca.bookuser.exceptions.UserAppNotDeletedException;
import br.com.biblioteca.bookuser.user.UserAppRepository;
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

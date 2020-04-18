package br.com.biblioteca.bookuser.user.services;

import br.com.biblioteca.bookuser.user.UserApp;
import br.com.biblioteca.bookuser.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@Service
public class SaveUserAppServiceImpl implements SaveUserAppService {

    private final UserAppRepository userAppRepository;

    @Override
    public void insert(UserApp userApp) {
        userAppRepository.save(userApp);
        userApp.setSpecificID(gerarHash(userApp.getId()));
        userAppRepository.save(userApp);
    }

    public static byte[] gerarHash(Long id) {
        String frase = "user"+id;
        String algoritmo = "MD5";
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(frase.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}

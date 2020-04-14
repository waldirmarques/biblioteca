package br.com.apibiblioteca.userbook.user.services;


import br.com.apibiblioteca.userbook.user.UserApp;
import br.com.apibiblioteca.userbook.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListPageUserAppServiceImpl implements ListPageUserAppService {

    private final UserAppRepository userAppRepository;

    @Override
    public Page<UserApp> findPage(Integer page, Integer size) {
        Pageable pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"id");
        return userAppRepository.findAll(pageRequest);
    }
}

package br.com.biblioteca.bookuser.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {

    Optional<UserApp> findBySpecificID(String specificID);

    //@Query("SELECT user FROM user_app user WHERE user.specificid = :id")
    //List<UserApp> findAllSpecificID(@Param("id") String id);

}

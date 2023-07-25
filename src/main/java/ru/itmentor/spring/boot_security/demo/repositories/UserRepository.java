package ru.itmentor.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.entity.User;

import java.util.Optional;

/**
 * \* Create by Prekrasnov Sergei
 * \
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u join fetch u.roles where u.email=:email")
    Optional<User> findUserByEmail(@Param("email") String email);

    User findUserById(@Param("id") Integer id);
}
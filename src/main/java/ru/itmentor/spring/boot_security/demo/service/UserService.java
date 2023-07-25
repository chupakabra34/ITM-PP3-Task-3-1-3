package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.entity.User;

import java.util.List;

/**
 * \* Create by Prekrasnov Sergei
 * \
 */

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);

}
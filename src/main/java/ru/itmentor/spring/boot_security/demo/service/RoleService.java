package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.entity.Role;

import java.util.List;

/**
 * \* Create by Prekrasnov Sergei
 * \
 */

public interface RoleService {
    List<Role> getRoles();

    void addRole(Role role);
}
package ru.itmentor.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import ru.itmentor.spring.boot_security.demo.entity.Role;
import ru.itmentor.spring.boot_security.demo.entity.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * \* Create by Prekrasnov Sergei
 * \
 */

@Component
public class DBInit {
    private final UserService userService;
    private final RoleService roleService;

    public DBInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initDB() {
        Role roleAdmin = new Role(1, "ROLE_ADMIN");
        Role roleUser = new Role(2, "ROLE_USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);
        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);
        User admin = new User(1, "admin", "Sergei", "Prekrasnov", 45,
                "sap685@gmail.com", "111", adminSet);
        admin.setId(1);
        User user = new User(2, "user",
                "Ivan", "Ivanov", 33,
                "ivan@ivan.ru", "321", userSet);
        user.setId(2);
        userService.saveUser(admin);
        userService.saveUser(user);
    }
}
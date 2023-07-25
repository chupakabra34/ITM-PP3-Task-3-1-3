package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.entity.User;
import ru.itmentor.spring.boot_security.demo.repositories.UserRepository;

import java.util.List;

/**
 * \* Create by Prekrasnov Sergei
 * \
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    @Lazy
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {//+
        return userRepository.findUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {//+
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            try {
                throw new Exception("Duplicate email");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User oldUser = getUserById(user.getId());
        if (user.getPassword().equals("") || user.getPassword() == null) {
            user.setPassword(oldUser.getPassword());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {//+
        userRepository.deleteById(id);
    }
}
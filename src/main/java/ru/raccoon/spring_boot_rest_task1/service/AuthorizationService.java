package ru.raccoon.spring_boot_rest_task1.service;

import org.springframework.stereotype.Service;
import ru.raccoon.spring_boot_rest_task1.exception.InvalidCredentials;
import ru.raccoon.spring_boot_rest_task1.exception.UnauthorizedUser;
import ru.raccoon.spring_boot_rest_task1.repository.Authorities;
import ru.raccoon.spring_boot_rest_task1.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        final List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
package uz.ems.testcicd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ems.testcicd.model.User;
import uz.ems.testcicd.model.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User login(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .orElseThrow();
    }
}


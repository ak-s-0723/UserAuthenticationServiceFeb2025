package org.example.userauthenticationservicefeb2025.services;

import org.example.userauthenticationservicefeb2025.exceptions.IncorrectPasswordException;
import org.example.userauthenticationservicefeb2025.exceptions.UserAlreadyExistException;
import org.example.userauthenticationservicefeb2025.exceptions.UserNotFoundException;
import org.example.userauthenticationservicefeb2025.models.User;
import org.example.userauthenticationservicefeb2025.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User signup(String email, String password) {
        Optional<User> userOptional = userRepo.findUserByEmailId(email);
        if(userOptional.isPresent()) {
          throw new UserAlreadyExistException("Please try login.");
        }

        User user = new User();
        user.setEmailId(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepo.save(user);
    }

    @Override
    public User login(String email, String password) {
        Optional<User> userOptional = userRepo.findUserByEmailId(email);
        if(userOptional.isEmpty()) {
           throw new UserNotFoundException("Please signup first");
        }

        String storedPassword = userOptional.get().getPassword();

        if(!bCryptPasswordEncoder.matches(password,storedPassword)) {
            throw new IncorrectPasswordException("Please pass correct password, otherwise reset your password");
        }

        return userOptional.get();
    }
}

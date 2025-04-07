package org.example.userauthenticationservicefeb2025.security;

import org.example.userauthenticationservicefeb2025.models.User;
import org.example.userauthenticationservicefeb2025.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepo.findUserByEmailId(email);

        if(userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User doesnt exist in system");
        }

        User user = userOptional.get();
        return new CustomUserDetails(user);
    }
}

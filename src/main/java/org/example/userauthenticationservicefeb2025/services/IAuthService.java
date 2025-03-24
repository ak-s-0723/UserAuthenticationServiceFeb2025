package org.example.userauthenticationservicefeb2025.services;

import org.example.userauthenticationservicefeb2025.models.User;

public interface IAuthService {
    User signup(String email,String password);

    User login(String email,String password);
}

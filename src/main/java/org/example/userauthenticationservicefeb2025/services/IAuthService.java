package org.example.userauthenticationservicefeb2025.services;

import org.antlr.v4.runtime.misc.Pair;
import org.example.userauthenticationservicefeb2025.models.User;

public interface IAuthService {
    User signup(String email,String password);

    Pair<User,String> login(String email, String password);

    Boolean validateToken(String token,Long userId);
}

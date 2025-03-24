package org.example.userauthenticationservicefeb2025.controllers;

import org.example.userauthenticationservicefeb2025.dtos.LoginRequestDto;
import org.example.userauthenticationservicefeb2025.dtos.LogoutRequestDto;
import org.example.userauthenticationservicefeb2025.dtos.SignupRequestDto;
import org.example.userauthenticationservicefeb2025.dtos.UserDto;
import org.example.userauthenticationservicefeb2025.models.User;
import org.example.userauthenticationservicefeb2025.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto signupRequestDto) {
      User user = authService.signup(signupRequestDto.getEmailId(),signupRequestDto.getPassword());
      return from(user);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginRequestDto loginRequestDto) {
      User user = authService.login(loginRequestDto.getEmailId(),loginRequestDto.getPassword());
      return from(user);
    }

    @PostMapping("/logout")
    public Boolean logout(@RequestBody LogoutRequestDto logoutRequestDto) {
      //ToDo -: To be implemented by Learners
      return false;
    }

    private UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmailId(user.getEmailId());
        return userDto;
    }
}

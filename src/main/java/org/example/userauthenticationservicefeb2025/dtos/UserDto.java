package org.example.userauthenticationservicefeb2025.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.userauthenticationservicefeb2025.models.Role;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String emailId;
    private Role role;
}

package org.example.userauthenticationservicefeb2025.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User extends BaseModel {
    private String emailId;
    private String password;
}

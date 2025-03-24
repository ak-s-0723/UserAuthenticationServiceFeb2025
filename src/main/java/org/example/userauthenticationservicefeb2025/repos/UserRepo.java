package org.example.userauthenticationservicefeb2025.repos;

import org.example.userauthenticationservicefeb2025.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}

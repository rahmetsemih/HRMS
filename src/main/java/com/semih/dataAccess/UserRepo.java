package com.semih.dataAccess;

import com.semih.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User>findByMail(String mail);
}

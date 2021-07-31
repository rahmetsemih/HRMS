package com.semih.dataAccess;

import com.semih.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerRepo extends JpaRepository <Employer,Long> {
    Optional<Employer> findByUser_Mail(String mail);
}

package com.semih.dataAccess;

import com.semih.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {


    Optional<Employee> findByIdentity(String identity);

    @Query(value = "select e.*, u.* from employee e right JOIN users u ON e.user_id = u.id where u.mail =:mail OR e.identity=:identity", nativeQuery = true)
    Employee findByMailOrIdentıty(String mail, String identity);
}

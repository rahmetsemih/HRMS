package com.semih.dataAccess;


import com.semih.entities.Employer;
import com.semih.entities.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPositionRepo extends JpaRepository<JobPosition,Long> {
    Optional<JobPosition> findByJobName(String jobName);
}

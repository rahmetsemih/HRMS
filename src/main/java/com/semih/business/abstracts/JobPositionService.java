package com.semih.business.abstracts;

import com.semih.core.utilities.results.Result;
import com.semih.model.dto.JobPositionDto;

import java.util.List;

public interface JobPositionService {
    Result saveJob(JobPositionDto registerRequest);
    List<JobPositionDto> getAll();
}

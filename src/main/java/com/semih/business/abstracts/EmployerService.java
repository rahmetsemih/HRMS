package com.semih.business.abstracts;

import com.semih.core.utilities.results.Result;
import com.semih.model.EmployerRegisterRequest;
import com.semih.model.dto.EmployerDto;

import java.util.List;

public interface EmployerService {
    Result register(EmployerRegisterRequest registerRequest);

    List<EmployerDto> getAll();
}

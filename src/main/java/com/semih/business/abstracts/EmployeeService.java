package com.semih.business.abstracts;

import com.semih.core.utilities.results.Result;
import com.semih.model.EmployeeRegisterRequest;
import com.semih.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService  {
    Result register(EmployeeRegisterRequest registerRequest);
    List<EmployeeDto> getAll();
}

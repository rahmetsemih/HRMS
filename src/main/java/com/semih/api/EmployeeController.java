package com.semih.api;

import com.semih.business.abstracts.EmployeeService;
import com.semih.business.concretes.EmployeeManager;
import com.semih.core.utilities.results.Result;
import com.semih.model.EmployeeRegisterRequest;
import com.semih.model.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping(value="/register")
    public Result register(@RequestBody @Valid EmployeeRegisterRequest registerRequest){
        return employeeService.register(registerRequest);
    }
    @GetMapping
    public List<EmployeeDto> getAll(){
       return employeeService.getAll();
    }
}

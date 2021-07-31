package com.semih.api;

import com.semih.business.abstracts.EmployerService;
import com.semih.core.utilities.results.Result;
import com.semih.model.EmployerRegisterRequest;
import com.semih.model.dto.EmployerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employer")
@RequiredArgsConstructor

public class EmployerController {
    private final EmployerService employerService;

    @PostMapping(value = "/register")
    public Result register(@RequestBody @Valid EmployerRegisterRequest register) {
        return employerService.register(register);

    }
    @GetMapping
    public List<EmployerDto> getAll(){
        return employerService.getAll();
    }
}
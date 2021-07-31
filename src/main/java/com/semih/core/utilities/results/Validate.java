package com.semih.core.utilities.results;

import com.semih.model.EmployeeRegisterRequest;
import com.semih.model.EmployerRegisterRequest;

public interface Validate {
    static boolean employerValidate(EmployerRegisterRequest registerRequest){
        String[] split = registerRequest.getWebSite().split("\\.");
        return split.length > 2 && registerRequest.getCompanyName().equals(split[1]);
    }

    static boolean employeeValidate(EmployeeRegisterRequest registerRequest){
        return registerRequest.getPassword().equals(registerRequest.getRePassword());
    }
}

package com.semih.business.concretes;

import com.semih.business.abstracts.EmployeeService;
import com.semih.client.MernisService;
import com.semih.converter.EmployeeConverter;
import com.semih.core.utilities.results.ErrorDataResult;
import com.semih.core.utilities.results.Result;
import com.semih.core.utilities.results.SuccessDataResult;
import com.semih.core.utilities.results.Validate;
import com.semih.dataAccess.EmployeeRepo;
import com.semih.dataAccess.EmployerRepo;
import com.semih.dataAccess.UserRepo;
import com.semih.entities.Employee;
import com.semih.entities.Employer;
import com.semih.entities.User;
import com.semih.model.EmployeeRegisterRequest;
import com.semih.model.dto.EmployeeDto;
import com.semih.model.dto.EmployerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
    private  final MernisService mernisService;
    private final EmployeeRepo employeeRepo;
    private final EmployeeConverter employeeConverter;
    private final UserRepo userRepo;

    @Override
    public Result register(EmployeeRegisterRequest registerRequest) {
        if(!Validate.employeeValidate(registerRequest))
            return new ErrorDataResult("2 şifre aynı olmalıdır.", registerRequest);
        if(userRepo.findByMail(registerRequest.getMail()).isPresent() || employeeRepo.findByIdentity(registerRequest.getIdentity()).isPresent()){
            return new ErrorDataResult("Email yada TcNo sistemimizde kayıtlı", registerRequest);
        }
        if(mernisService.validate(registerRequest.getIdentity())){
            return new ErrorDataResult("Mernis doğrulama başarısız", registerRequest);
        };
        employeeRepo.save(employeeConverter.toEntity(registerRequest));
        return new SuccessDataResult("Kayıt başarıyla tamamlandı", registerRequest);
    }
    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> all = employeeRepo.findAll();
        return all.stream().map(employee-> employeeConverter.toDto(employee)).collect(Collectors.toList());
    }
}

package com.semih.business.concretes;

import com.semih.business.abstracts.EmployerService;
import com.semih.client.EpostaValidateService;
import com.semih.converter.EmployerConverter;
import com.semih.core.utilities.results.*;
import com.semih.dataAccess.EmployerRepo;
import com.semih.dataAccess.UserRepo;
import com.semih.entities.Employer;
import com.semih.entities.JobPosition;
import com.semih.model.EmployerRegisterRequest;
import com.semih.model.dto.EmployerDto;
import com.semih.model.dto.JobPositionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class EmployerManager implements EmployerService {
private final EmployerRepo employerRepo;
private final EpostaValidateService epostaValidateService;
private final EmployerConverter employerConverter;
private final UserRepo userRepo;


    @Override
    public Result register(EmployerRegisterRequest registerRequest) {
        if(!Validate.employerValidate(registerRequest))
            return new ErrorDataResult("Bireysel giriş yapılamaz!",registerRequest);
        if(userRepo.findByMail(registerRequest.getMail()).isPresent())
            return new ErrorDataResult("Bu e posta zaten kayıtlı!",registerRequest);
        if(!epostaValidateService.epostavalidate(registerRequest.getMail()))
             return new DataResult(false,"E-posta doğrulaması yapıldı..",registerRequest);
        employerRepo.save(employerConverter.toEntity(registerRequest));
        return new SuccessDataResult("başarılı", registerRequest);

    }
    @Override
    public List<EmployerDto> getAll() {
        List<Employer> all = employerRepo.findAll();
        return all.stream().map(e-> employerConverter.toDto(e)).collect(Collectors.toList());
    }
}

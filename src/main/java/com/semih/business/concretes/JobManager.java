package com.semih.business.concretes;

import com.semih.business.abstracts.JobPositionService;
import com.semih.converter.JobPositionConverter;
import com.semih.core.utilities.results.ErrorDataResult;
import com.semih.core.utilities.results.Result;
import com.semih.core.utilities.results.SuccessDataResult;
import com.semih.dataAccess.JobPositionRepo;
import com.semih.entities.JobPosition;
import com.semih.model.dto.JobPositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JobManager implements JobPositionService {
    private final JobPositionRepo jobPositionRepo;
    private final JobPositionConverter jobPositionConverter;

    @Override
    public Result saveJob(JobPositionDto registerRequest) {
        if(jobPositionRepo.findByJobName(registerRequest.getName()).isPresent())
            return new ErrorDataResult("Bu meslek zaten kayıtlı!",registerRequest);
        JobPosition save = jobPositionRepo.save(jobPositionConverter.toEntity(registerRequest));
        return new SuccessDataResult("Kayıt başarıyla eklendi", save);
    }

    @Override
    public List<JobPositionDto> getAll() {
        List<JobPosition> all = jobPositionRepo.findAll();
        return all.stream().map(e-> jobPositionConverter.toDto(e)).collect(Collectors.toList());
    }
}

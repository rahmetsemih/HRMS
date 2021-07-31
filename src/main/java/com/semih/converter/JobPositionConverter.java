package com.semih.converter;

import com.semih.entities.JobPosition;
import com.semih.model.dto.JobPositionDto;
import org.springframework.stereotype.Component;

@Component
public class JobPositionConverter {
    public JobPosition toEntity(JobPositionDto registerRequest){
       return JobPosition.builder().jobName(registerRequest.getName()).build();
    }

    public JobPositionDto toDto(JobPosition entity){
        return JobPositionDto.builder().id(entity.getId()).name(entity.getJobName()).build();
    }
}

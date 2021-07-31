package com.semih.converter;

import com.semih.entities.Employee;
import com.semih.entities.Employer;
import com.semih.entities.JobPosition;
import com.semih.entities.User;
import com.semih.model.EmployerRegisterRequest;
import com.semih.model.dto.EmployerDto;
import com.semih.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class EmployerConverter {
    public Employer toEntity(EmployerRegisterRequest registerRequest) {
        return Employer.builder()

                .companyName(registerRequest.getCompanyName())
                .user(User.builder().mail(registerRequest.getMail())
                        .password(registerRequest.getPassword()).build())
                .webSite(registerRequest.getWebSite())
                .phone(registerRequest.getPhone())
                .build();
    }

    public EmployerDto toDto(Employer e) {
        return EmployerDto.builder()
                .id(e.getId())

                .companyName(e.getCompanyName())
                .userDto(UserDto.builder().
                        id(e.getUser().getId()).mail(e.getUser().getMail())
                        .password(e.getUser().getPassword()).build())
                .webSite(e.getWebSite())
                .phone(e.getPhone())
                .build();
    }
}

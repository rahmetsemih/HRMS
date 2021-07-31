package com.semih.converter;

import com.semih.entities.Employee;
import com.semih.entities.User;
import com.semih.model.EmployeeRegisterRequest;
import com.semih.model.dto.EmployeeDto;
import com.semih.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

   public Employee toEntity(EmployeeRegisterRequest registerRequest){
        return Employee.builder()
                .name(registerRequest.getName())
                .lastName(registerRequest.getLastName())
                .birthYear(registerRequest.getBirthYear())
                .user(User.builder().mail(registerRequest.getMail()).password(registerRequest.getPassword()).build())
                .identity(registerRequest.getIdentity())
                .build();
    }

    public EmployeeDto toDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .birthYear(employee.getBirthYear())
                .userDto(UserDto.builder().id(employee.getUser().getId()).mail(employee.getUser().getMail()).password(employee.getUser().getPassword()).build())
                .identity(employee.getIdentity())
                .build();
    }
}

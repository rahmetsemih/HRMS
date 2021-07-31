package com.semih.model.dto;

import com.semih.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private long id;
    private String name;
    private String lastName;
    private String identity;
    private String birthYear;
    private UserDto userDto;

}

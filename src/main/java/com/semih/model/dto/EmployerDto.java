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
public class EmployerDto {
    private long id;
    private String companyName;
    private String webSite;
    private String phone;
    private UserDto userDto;

}

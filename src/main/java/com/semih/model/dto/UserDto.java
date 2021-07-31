package com.semih.model.dto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {
    private int id;
    private String mail;
    private String password;
}

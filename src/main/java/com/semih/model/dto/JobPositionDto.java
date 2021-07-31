package com.semih.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JobPositionDto {
    private long id;
    @NotBlank(message = "Meslek ismi boş bırakılamaz!")
    private String name;
}

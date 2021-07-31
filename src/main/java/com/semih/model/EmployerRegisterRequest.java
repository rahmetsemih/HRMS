package com.semih.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployerRegisterRequest {
    @NotBlank(message = "Mail boş bırakılamaz")
    private String mail;
    @NotBlank(message = "Şifre boş bırakılamaz")
    private String password;
    @NotBlank (message ="Şifre tekrarı boş bırakılamaz")
    private String rePassword;
    @NotBlank(message = "Şirket Adı boş bırakılamaz")
    private String companyName;
    @NotBlank(message = "Web site adı  boş bırakılamaz")
    private String webSite;
    @NotBlank(message = "Telefon numarası boş bırakılamaz")
    private String phone;

}

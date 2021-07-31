package com.semih.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeRegisterRequest {
    @NotBlank(message = "Mail boş bırakılamaz")
    private String mail;
    @NotBlank(message = "Şifre boş bırakılamaz")
    private String password;
    @NotBlank(message = "Şifre tekrarı boş bırakılamaz")
    private String rePassword;
    @NotBlank(message = "İsim boş bırakılamaz")
    private String name;
    @NotBlank(message = "Soy isim boş bırakılamaz")
    private String lastName;
    @NotBlank(message = "Tc no  boş bırakılamaz")
    private String identity;
    @NotBlank(message = "Doğum yılı boş bırakılamaz")
    private String birthYear ;

}

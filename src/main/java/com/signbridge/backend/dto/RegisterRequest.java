package com.signbridge.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Name can not be Empty")
    @Size(min = 2,max = 50,message = "Name must be 2-50 characters")
    private String name;

    @NotBlank(message = "Email can not be Empty")
    @Email(message = "Invalid Email format")
    private String email;

    @NotBlank(message = "Password can not be Empty")
    @Size(min = 6,max = 20,message = "Password must be 6-20 characters")
    private String password;
}

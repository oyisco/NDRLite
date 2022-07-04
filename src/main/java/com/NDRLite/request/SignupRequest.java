package com.NDRLite.request;

import lombok.Data;

import java.util.Set;

import javax.validation.constraints.*;
 @Data
public class SignupRequest {
    @NotBlank
    @Size(max = 50)
    @Email
    private String username;
    private Set<String> role;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}

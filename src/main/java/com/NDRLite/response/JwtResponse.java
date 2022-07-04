package com.NDRLite.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private String username;


}

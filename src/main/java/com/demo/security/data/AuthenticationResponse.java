package com.demo.security.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter

public class AuthenticationResponse
{
    private final String jwt;
}

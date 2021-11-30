package com.demo.controller;

import com.demo.security.JwtUtil;
import com.demo.security.data.AuthenticationRequest;
import com.demo.security.data.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
public class LoginRestController {

    private final AuthenticationManager manager;

    private final UserDetailsService service;

    private final JwtUtil util;

    @Autowired
    public LoginRestController(AuthenticationManager manager, UserDetailsService service, JwtUtil util)
    {
        this.manager = manager;
        this.service = service;
        this.util = util;
    }

    @PostMapping(value = "/login" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> entity(@RequestBody AuthenticationRequest request){
        try
        {
            manager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getName(),request.getPassword())
            );

        } catch (AuthenticationException e)
        {
            throw new RuntimeException(e.getMessage());
        }

        final UserDetails userDetails=service.loadUserByUsername(request.getName());
        final  String jwt=util.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}

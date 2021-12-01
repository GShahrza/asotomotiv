package com.demo.controller;

import com.demo.entity.Users;
import com.demo.service.email.SendingEmailService;
import com.demo.service.impl.UsersService;
import com.demo.util.Verification;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class SignUpRestController {

    private final SendingEmailService sendingEmailService;

    @Autowired
    public SignUpRestController(SendingEmailService sendingEmailService) {
        this.sendingEmailService = sendingEmailService;
    }

    @PostMapping("/signup")
    public Boolean signUp(@RequestBody Users users){
        return sendingEmailService.signUp(users);
    }

    @PostMapping("/verification")
    public Boolean verification(@RequestBody Verification code){
        return sendingEmailService.verificationCode(code);

    }
   
}

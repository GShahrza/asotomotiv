package com.demo.service.email;

import com.demo.entity.Users;
import com.demo.service.impl.UsersService;
import com.demo.util.Verification;
import lombok.Getter;
import lombok.Setter;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.ThreadLocalRandom;
@Component
public class SendingEmailService {
    private final UsersService usersService;

    private final JavaMailSender sender;

    @Setter
    @Getter
    private String code;

    private Users users;

    public SendingEmailService(UsersService usersService, JavaMailSender sender)
    {
        this.usersService = usersService;
        this.sender = sender;
    }

    public Boolean signUp(Users users)
    {
        sendMail(users.getEmail());
        this.users=users;
        return true;
    }

    public Boolean sendMail(String email)
    {
        try
        {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setSubject("Verification Code");
            msg.setText(generateNumbers().toString());
            msg.setTo(email);
            sender.send(msg);
            setCode(msg.getText());
            return true;
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return  false;
        }
    }

    public boolean verificationCode(Verification verification)
    {
        if (verification.getCode().equals(getCode()) )
        {
            usersService.addAndUpdateUser(users);
            return true;
        }
        else{
            return false;
        }
    }

    private Integer generateNumbers(){
        int min=122356;
        int max=987668;
        return ThreadLocalRandom.current().nextInt( min, max);
    }
}

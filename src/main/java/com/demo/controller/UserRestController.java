package com.demo.controller;

import com.demo.entity.Users;
import com.demo.service.inter.UsersServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
public class UserRestController {

    private final UsersServiceInter usersService;
    @Autowired

    public UserRestController(UsersServiceInter usersService)
    {
        this.usersService = usersService;
    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers()
    {
        return usersService.findAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public Users getUsers(@PathVariable int id)
    {
        return usersService.findByUsers(id);
    }

    @PostMapping("/update")
    public Boolean updateUser(@RequestBody Users users)
    {
        return usersService.addAndUpdateUser(users);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteUser(@PathVariable int id)
    {
        return usersService.deleteUser(id);
    }
}

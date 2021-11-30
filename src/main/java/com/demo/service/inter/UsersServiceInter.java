package com.demo.service.inter;

import com.demo.entity.Users;

import java.util.List;

public interface UsersServiceInter {

    Boolean addAndUpdateUser(Users user);

    void addProfile(Users user);

    List<Users> findAllUsers();

    Users findByUsers(int id);

    Boolean deleteUser(int id);
}

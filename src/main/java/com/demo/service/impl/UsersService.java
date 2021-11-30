package com.demo.service.impl;

import com.demo.entity.UserProfile;
import com.demo.entity.Users;
import com.demo.repository.UserDetailsRepository;
import com.demo.repository.UserProfileRepository;
import com.demo.service.inter.UsersServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements UsersServiceInter {

    private final UserDetailsRepository detailsRepository;

    private final UserProfileRepository profileRepository;

    private final PasswordEncoder encoder;
    @Autowired
    public UsersService(UserDetailsRepository detailsRepository, UserProfileRepository profileRepository, PasswordEncoder encoder)
    {
        this.detailsRepository = detailsRepository;
        this.profileRepository = profileRepository;
        this.encoder = encoder;
    }

    @Override
    public Boolean addAndUpdateUser(Users user)
    {
        try
        {
            user.setPassword(encoder.encode(user.getPassword()));
            addProfile(user);
            Users returningUser = detailsRepository.save(user);

            return user.equals(returningUser );
        }catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public void addProfile(Users user)
    {
        try
        {
            UserProfile userProfile = new UserProfile(user.getId(),user.getUserName(), user.getPassword(), "USER_ROLES");
            profileRepository.save(userProfile);
        } catch (RuntimeException ex)
        {
            throw new RuntimeException("Can not sign up!");
        }
    }

    @Override
    public List<Users> findAllUsers()
    {
        try
        {
            return detailsRepository.findAll();
        }catch (Exception ex)
        {
            return new ArrayList<>();
        }
    }

    @Override
    public Users findByUsers(int id)
    {
        try
        {
            return detailsRepository.findById(id).get();
        }catch (Exception ex)
        {
            return new Users();
        }
    }

    @Override
    public Boolean deleteUser(int id)
    {
        try
        {
            detailsRepository.delete(findByUsers(id));
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}

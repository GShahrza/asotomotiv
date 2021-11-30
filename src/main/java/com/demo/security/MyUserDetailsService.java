package com.demo.security;

import com.demo.entity.UserProfile;
import com.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserProfileRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserProfile> user=repository.findByUserName(name);
        user.orElseThrow(()->new UsernameNotFoundException("User Not Found!"));
        return user.map(MyUserDetails::new).get();
    }
}

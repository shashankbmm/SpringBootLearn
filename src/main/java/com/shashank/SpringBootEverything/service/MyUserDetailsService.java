package com.shashank.SpringBootEverything.service;

import com.shashank.SpringBootEverything.model.User;
import com.shashank.SpringBootEverything.model.UserPrinciple;
import com.shashank.SpringBootEverything.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);

        if (user == null){
            throw new RuntimeException();
        }

        return new UserPrinciple(user);
    }
}

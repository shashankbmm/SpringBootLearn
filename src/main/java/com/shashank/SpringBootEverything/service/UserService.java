package com.shashank.SpringBootEverything.service;


import com.shashank.SpringBootEverything.model.User;
import com.shashank.SpringBootEverything.model.UserDto;
import com.shashank.SpringBootEverything.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public List<User> getAllUsers(){
        return userRepo.findAll().stream().toList();
    }

    public User getUserByID(Integer ID){
        return userRepo.findById(ID).get();
    }

    public User createUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User updateUser(Integer ID, User user){
        User existingUser = userRepo.findById(ID).orElse(new User());
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        return userRepo.save(existingUser);
    }

    public String deleteUser(Integer ID){
        userRepo.deleteById(ID);
        return "Deleted Successfully";
    }


    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setMobile(user.getMobile());
        return userDto;
    }

    public User mapToUser(UserDto userDto){
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setMobile(userDto.getMobile());
        return user;
    }

}

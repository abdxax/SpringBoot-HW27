package com.example.springboothw27.service;

import com.example.springboothw27.model.MyUser;
import com.example.springboothw27.repstiotry.AuthRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserSerivce {
    private final AuthRepstory authRepstory;

    public void register(MyUser myUser){
        String password=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(password);
        authRepstory.save(myUser);
    }
}

package com.example.springboothw27.service;

import com.example.springboothw27.model.MyUser;
import com.example.springboothw27.repstiotry.AuthRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final AuthRepstory authRepstory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user=authRepstory.findMyUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("The user name or password is not correct");
        }
        return user;
    }
}

package com.example.springboothw27.controller;

import com.example.springboothw27.model.MyUser;
import com.example.springboothw27.repstiotry.AuthRepstory;
import com.example.springboothw27.service.MyUserSerivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MyUserSerivce myUserSerivce;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid MyUser user){
        myUserSerivce.register(user);
       return ResponseEntity.status(HttpStatus.OK).body("Register done");
    }

    @PostMapping("/login")
    public ResponseEntity login(){

        return ResponseEntity.status(HttpStatus.OK).body("Welcome");
    }
    @PostMapping("/logout")
    public ResponseEntity logout(){

        return ResponseEntity.status(HttpStatus.OK).body("good bye ");
    }
}

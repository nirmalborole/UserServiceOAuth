package com.example.userserviceoauth.controllers;

import com.example.userserviceoauth.dtos.SignUpRequestDto;
import com.example.userserviceoauth.dtos.ValidateTokenRequestDto;
import com.example.userserviceoauth.models.Token;
import com.example.userserviceoauth.models.User;
import com.example.userserviceoauth.repository.UserRepository;
import com.example.userserviceoauth.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequestDto requestDto){
        try{
            User user= userService.signUp(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
            return new ResponseEntity<>(user, HttpStatusCode.valueOf(201));
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody SignUpRequestDto requestDto){
        return  null;
    }

    @PostMapping("/validateToken")
    public ResponseEntity<Token> validateToken(@RequestBody ValidateTokenRequestDto requestDto){
        return null;
    }
}

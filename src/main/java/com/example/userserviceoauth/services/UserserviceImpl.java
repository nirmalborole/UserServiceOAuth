package com.example.userserviceoauth.services;

import com.example.userserviceoauth.models.User;
import com.example.userserviceoauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserserviceImpl implements UserService{
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserserviceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public User signUp(String name, String email, String password) throws Exception {

        Optional<User> otionalUser = this.userRepository.findUserByEmail(email);

        if(otionalUser.isPresent()){
            throw new Exception("User already exist");
        }

        String encodedPassword = this.bCryptPasswordEncoder.encode(password);

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(encodedPassword);

        return this.userRepository.save(user);
    }
}

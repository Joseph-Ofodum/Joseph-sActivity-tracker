package com.example.week8.serviceImpl;

import com.example.week8.dto.LogInDto;
import com.example.week8.dto.SignUpDto;
import com.example.week8.repositories.UserRepo;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceImplTest {


    @Autowired
     private UserServiceImpl service;
    @Autowired
   private UserRepo userRepo;

    @Test
    void signUp() {
        SignUpDto signUp = new SignUpDto();
        signUp.setFirstName("Ekene");
        signUp.setLastName("ofodum");
        signUp.setUserName("mgbo");
        signUp.setPassword("1234");

        assertEquals("Ekene",service.signUp(signUp).getFirstName());
    }

    @Test
    void logIn() {
        LogInDto logInDto = new LogInDto();
        logInDto.setUserName("mgbo");
        logInDto.setPassword("1234");

        assertEquals("1234",service.logIn(logInDto).getPassword());
    }

//    @After
//    public void tearDown(){
//        service.deleteUserByUserName("libAustine");
//    }
}
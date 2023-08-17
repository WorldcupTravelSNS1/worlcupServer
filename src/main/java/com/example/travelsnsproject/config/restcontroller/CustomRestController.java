package com.example.travelsnsproject.config.restcontroller;


import com.example.travelsnsproject.config.exception.NoMatchMember;
import com.example.travelsnsproject.config.exception.NotValidToken;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.io.NotActiveException;

@RestController
public class CustomRestController {
    @ExceptionHandler(NotActiveException.class)
    public ResponseEntity<String> noToken(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoMatchMember.class)
    public ResponseEntity<String> noMatchMember(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotValidToken.class)
    public  ResponseEntity<String> NotValidToken(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}

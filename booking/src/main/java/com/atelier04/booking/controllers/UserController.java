package com.atelier04.booking.controllers;

import com.atelier04.booking.models.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class UserController {


    @GetMapping(value = "/student")
    public ResponseEntity<String> test(){
        return  new ResponseEntity<>("Hallo von BookingController",HttpStatus.OK);
    }
    @GetMapping(value = "/login")
    public ResponseEntity<UserData> login(@RequestBody UserData userData){

        return  new ResponseEntity<>(userData,HttpStatus.OK);
    }

}

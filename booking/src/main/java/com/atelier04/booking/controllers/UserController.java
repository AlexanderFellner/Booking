package com.atelier04.booking.controllers;

import com.atelier04.booking.models.Room;
import com.atelier04.booking.models.UserData;
import com.atelier04.booking.services.RoomService;
import com.atelier04.booking.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDataService userDataService;

    @Autowired
    RoomService roomService;
    @GetMapping(value = "/student")
    public ResponseEntity<String> test(){
        return  new ResponseEntity<>("Hallo von BookingController",HttpStatus.OK);
    }
    @GetMapping(value = "/login")
    public ResponseEntity<UserData> login(@RequestBody UserData userData){
       // authenticationManager.authenticate();
        return  new ResponseEntity<>(userData,HttpStatus.OK);
    }
    @GetMapping("/register")
    public ResponseEntity<UserData> register(@RequestBody UserData userData){
        return ResponseEntity.ok(userDataService.save(userData));
    }
    @GetMapping("/freerooms")
    public ResponseEntity<List<Room>> getFreeRooms(){
        return  ResponseEntity.ok(userDataService.getFreeRooms());
    }
    @PostMapping("/addroom")
    public ResponseEntity<String> addRoom(@RequestBody Room room){

        Room room1=roomService.addRoom(room.isSmartBoard(),room.isWhiteBoard(),room.isAudio(),room.isProjector(),room.isPrinter(),room.getSeats(),room.getSection(),room.getCategory(),room.getDirections());
        Optional optroom=Optional.of(room1);
        if(optroom.isPresent()){
            return ResponseEntity.ok("Room was created");
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(500)).body("Room was not created");
    }

}

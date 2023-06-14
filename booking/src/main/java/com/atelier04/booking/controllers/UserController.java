package com.atelier04.booking.controllers;

import com.atelier04.booking.auth.JwtUtil;
import com.atelier04.booking.models.Room;
import com.atelier04.booking.models.UserData;
import com.atelier04.booking.services.BookingService;
import com.atelier04.booking.services.JwtDetailsService;
import com.atelier04.booking.services.RoomService;
import com.atelier04.booking.services.UserDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BookingService bookingService;
    @Autowired
    JwtDetailsService jwtDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    RoomService roomService;
    @Autowired
    UserDataService userDataService;




    @GetMapping(value = "/student")
    public ResponseEntity<String> test(){
        return  new ResponseEntity<>("Hallo von BookingController",HttpStatus.OK);
    }
    @GetMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody UserData userData){
     Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userData.getEmail(),userData.getPassword()));
     if(!authentication.isAuthenticated()){
        return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
     }
     UserDetails userDetails=jwtDetailsService.loadUserByUsername(userData.getEmail());
     String jwt=jwtUtil.generateToken(userDetails);
     return  new ResponseEntity<>(jwt,HttpStatus.OK);
    }
    @GetMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserData userData){
        UserData userDataSaved=userDataService.save(userData);
        UserDetails userDetails=jwtDetailsService.loadUserByUsername(userDataSaved.getEmail());
        final String jwt=jwtUtil.generateToken(userDetails);
        return new ResponseEntity<String>(jwt,HttpStatus.OK);
    }
    @GetMapping("/freerooms")
    public ResponseEntity<List<Room>> getFreeRooms(){
        return  ResponseEntity.ok(userDataService.getFreeRooms());
    }
    @PostMapping("/addroom")
    public ResponseEntity<String> addRoom(@RequestBody Room room){

        Room room1=roomService.addRoom(room.getName(),room.isSmartBoard(),room.isWhiteBoard(),room.isAudio(),room.isProjector(),room.isPrinter(),room.getSeats(),room.getSection(),room.getCategory(),room.getDirections());
        Optional optroom=Optional.of(room1);
        if(optroom.isPresent()){
            return ResponseEntity.ok("Room was created");
        }
        return ResponseEntity.ok("Room was not created");
        //return ResponseEntity.status(HttpStatusCode.valueOf(500)).body("Room was not created");
    }
    @PostMapping("/addbooking/{roomName}")
    public ResponseEntity<String> addBooking(@PathVariable String roomName ){

            Optional<Room> roomopt = roomService.getRoomByName(roomName);
            if (roomopt.isPresent()) {
                bookingService.addBooking(roomopt.get());
                return ResponseEntity.ok("Booking was made");
            }
            return ResponseEntity.ok("Booking was not made");


    }
    @GetMapping("/getroomswithspecialequipment/{typ}")
    public ResponseEntity<List<Room>> getRoomsWithSpecialEquipment(String typ){
        return ResponseEntity.ok(roomService.getRoomsWithSpecialEquipment(typ));
    }
    @GetMapping("/getroombylecture/{lecturename}")
    public ResponseEntity<Room> getRoomByLecture(@PathVariable String lecturename){
           return ResponseEntity.<Room>ok(roomService.getRoomByLecture(lecturename));
    }
    @GetMapping("/getroombyemployee/{employeename}")
    public ResponseEntity<Room> getRoomByEmployee(@PathVariable  String employeename){
        return ResponseEntity.<Room>ok(roomService.getRoomByEmployee(employeename));
    }

}

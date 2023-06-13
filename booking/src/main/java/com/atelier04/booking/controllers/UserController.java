package com.atelier04.booking.controllers;

import com.atelier04.booking.models.Room;
import com.atelier04.booking.models.UserData;
import com.atelier04.booking.services.BookingService;
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
    BookingService bookingService;
    @Autowired
    RoomService roomService;
    @Autowired
    UserDataService userDataService;


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

        Room room1=roomService.addRoom(room.getName(),room.isSmartBoard(),room.isWhiteBoard(),room.isAudio(),room.isProjector(),room.isPrinter(),room.getSeats(),room.getSection(),room.getCategory(),room.getDirections());
        Optional optroom=Optional.of(room1);
        if(optroom.isPresent()){
            return ResponseEntity.ok("Room was created");
        }
        return ResponseEntity.ok("Room was not created");
        //return ResponseEntity.status(HttpStatusCode.valueOf(500)).body("Room was not created");
    }
    @PostMapping("/addbooking/{roomidtext}")
    public ResponseEntity<String> addBooking(@PathVariable String roomidtext ){
        try {
            long roomId = Integer.parseInt(roomidtext);
            Optional<Room> roomopt = roomService.getRoomById(roomId);
            if (roomopt.isPresent()) {
                bookingService.addBooking(roomopt.get());
                return ResponseEntity.ok("Booking was made");
            }
            return ResponseEntity.ok("Booking was not made");
        }
        catch(NumberFormatException ex){
            return ResponseEntity.ok("Pathvariable is not a number" +ex.getMessage());
        }


    }

}

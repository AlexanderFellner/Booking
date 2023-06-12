package com.atelier04.booking.services;


import com.atelier04.booking.models.Room;
import com.atelier04.booking.repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    private BookingService bookingService;

    public List<Room> getAllRooms(){

        return roomRepo.findAll();

    }
    public List<Room> getFreeRooms(){
        return bookingService.getFreeRooms();


    }


}

package com.atelier04.booking.services;


import com.atelier04.booking.models.Room;
import com.atelier04.booking.repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private BookingService bookingService;


    public Optional<Room> getRoomById(Long id){
        Optional<Room> roomopt=roomRepo.findById(id);
        return roomopt;
    }

    public List<Room> getAllRooms(){

        return roomRepo.findAll();

    }
    public List<Room> getFreeRooms(){
        return bookingService.getFreeRooms();
    }

    public Room addRoom(String name,boolean smartBoard, boolean whiteBoard,boolean audio, boolean projector, boolean printer, int seats,String section, String category, String directions){
         Room room=Room.builder().name(name).smartBoard(smartBoard).whiteBoard(whiteBoard).audio(audio).projector(projector).printer(printer).category(category).seats(seats).section(section).directions(directions).build();
         return roomRepo.save(room);
    }
    public void deleteRoomByName(String name){
        Optional<Room> room=roomRepo.findByName(name);
        if(room.isPresent()){
            roomRepo.delete(room.get());
            System.out.println("The room with name "+name+" is deleted");
        }
    }
    public void deleteRoomById(Long id){
        Optional<Room> room=roomRepo.findById(id);
        if(room.isPresent()){
            roomRepo.delete(room.get());
            System.out.println("The room with id"+" is deleted");
        }
    }



}

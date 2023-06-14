package com.atelier04.booking.services;

import com.atelier04.booking.models.Lecture;
import com.atelier04.booking.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    BookingService bookingService;
    @Autowired
    LectureService lectureService;


    @Autowired
    RoomService roomService;

    public Lecture addLecture(LocalDateTime startTime, LocalDateTime endTime){

        return lectureService.addLecture(startTime,endTime);
    }
    public void deleteLecture(Lecture lecture){
        lectureService.deleteLecture(lecture);
    }

    public Room addRoom(String name,boolean smartBoard, boolean whiteBoard,boolean audio, boolean projector, boolean printer, int seats,String section, String country, String directions) {
        return roomService.addRoom(name,smartBoard,whiteBoard,audio,projector,printer,seats,section,country,directions);

    }
    public Room updateRoom(String name,boolean smartBoard, boolean whiteBoard,boolean audio, boolean projector, boolean printer, int seats,String section, String category, String directions){
          return roomService.updateRoom(name,smartBoard,whiteBoard,audio,projector,printer,seats,section,category,directions);
    }
    public boolean bookRoom(Long roomId){
        Optional<Room> roomopt=roomService.getRoomById(roomId);
        if(roomopt.isPresent()){
            return bookingService.addBooking(roomopt.get());
        }
        return false;
    }
    public boolean bookRoom(String roomName){
        Optional<Room> roomopt=roomService.getRoomByName(roomName);
        if(roomopt.isPresent()){
            return bookingService.addBooking(roomopt.get());
        }
        return false;
    }
    public boolean deleteRoom(String roomName){
        Optional<Room> roomopt=roomService.getRoomByName(roomName);
        if(roomopt.isPresent()){
            return roomService.deleteRoomByName(roomName);
        }
        return false;
    }
}

package com.atelier04.booking.services;

import com.atelier04.booking.models.Lecture;
import com.atelier04.booking.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminService {

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

    public Room addRoom(boolean smartBoard, boolean whiteBoard,boolean audio, boolean projector, boolean printer, int seats,String section, String country, String directions) {
        return roomService.addRoom(smartBoard,whiteBoard,audio,projector,printer,seats,section,country,directions);

    }
}

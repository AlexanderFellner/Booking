package com.atelier04.booking.services;


import com.atelier04.booking.models.Employee;
import com.atelier04.booking.models.Lecture;
import com.atelier04.booking.models.Room;
import com.atelier04.booking.repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmployeeService employeeService;


    @Autowired
    private LectureService lectureService;


    public Optional<Room> getRoomById(Long id){
        return roomRepo.findById(id);

    }
    public Optional<Room> getRoomByName(String name){
        return roomRepo.findByName(name);

    }

    public List<Room> getAllRooms(){

        return roomRepo.findAll();

    }
    public List<Room> getFreeRooms(){
        return bookingService.getFreeRooms();
    }

    public List<Room> getRoomsWithSpecialEquipment(String typ) {
        String typlower =typ.toLowerCase();

       return roomRepo.findAll().stream().filter(room -> {
            switch(typlower){
                case "audio": return room.isAudio();
                case "whiteboard":return room.isWhiteBoard();
                case "smartboard":return room.isSmartBoard();
                case "printer":return room.isPrinter();
                case "projector":return room.isProjector();
                default:
                    return false;

            }

        }).collect(Collectors.toList());
    }
    public Room getRoomByLecture(String lecturename){

            Optional<Lecture> lectureopt=lectureService.getLectureByName(lecturename);
            if(lectureopt.isPresent()){
                Lecture lect=lectureopt.get();
                return lect.getLectureRoom();
            }
            return null;

    }
    public Room getRoomByEmployee(String employeeName){
        Optional<Employee> employeeopt=employeeService.getEmployeeByName(employeeName);
        if(employeeopt.isPresent()){
            Lecture lecture=employeeopt.get().getLecture();
            return lecture.getLectureRoom();
        }
        return null;

    }

    public Room addRoom(String name,boolean smartBoard, boolean whiteBoard,boolean audio, boolean projector, boolean printer, int seats,String section, String category, String directions){
         Room room=Room.builder().name(name).smartBoard(smartBoard).whiteBoard(whiteBoard).audio(audio).projector(projector).printer(printer).category(category).seats(seats).section(section).directions(directions).build();
         return roomRepo.save(room);
    }
    public Room updateRoom(String name,boolean smartBoard, boolean whiteBoard,boolean audio, boolean projector, boolean printer, int seats,String section, String category, String directions){
        Optional<Room> roomOpt=roomRepo.findByName(name);
        if(roomOpt.isPresent()){
            Room room=roomOpt.get();
            room.setAudio(audio);
            room.setCategory(category);
            room.setPrinter(printer);
            room.setProjector(projector);
            room.setSmartBoard(smartBoard);
            room.setWhiteBoard(whiteBoard);
            room.setSection(section);
            room.setSeats(seats);
            room.setDirections(directions);
            return roomRepo.save(room);
        }
        return null;
    }
    public boolean deleteRoomByName(String name){
        Optional<Room> room=roomRepo.findByName(name);
        if(room.isPresent()){
            roomRepo.delete(room.get());
            System.out.println("The room with name "+name+" is deleted");
        }
        return false;
    }
    public void deleteRoomById(Long id){
        Optional<Room> room=roomRepo.findById(id);
        if(room.isPresent()){
            roomRepo.delete(room.get());
            System.out.println("The room with id"+" is deleted");
        }
    }



}

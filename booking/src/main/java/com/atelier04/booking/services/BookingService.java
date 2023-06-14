package com.atelier04.booking.services;

import com.atelier04.booking.models.Booking;
import com.atelier04.booking.models.Room;
import com.atelier04.booking.repositories.BookingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public List<Room> getFreeRooms(){
        List<Booking> bookings=bookingRepo.findAll();
        return bookings.stream().map(Booking::getBookingRoom).filter(room->LocalDateTime.now().isAfter(room.getBooking().getEndTime() ) && LocalDateTime.now().plusHours(3).isBefore(room.getBooking().getBookingTime())).collect(Collectors.toList());


    }
    public boolean addBooking(Room room){
        Booking booking=new Booking();
        booking.setBookingTime(LocalDateTime.now());
        booking.setEndTime(LocalDateTime.now().plusHours(2));
        booking.setBookingRoom(room);
        Booking savedBooking=bookingRepo.save(booking);
        if(savedBooking!=null){
            return true;
        }
        return false;
    }



}

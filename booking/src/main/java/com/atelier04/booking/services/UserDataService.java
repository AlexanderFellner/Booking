package com.atelier04.booking.services;



import com.atelier04.booking.models.Booking;
import com.atelier04.booking.models.Room;
import com.atelier04.booking.models.UserData;
import com.atelier04.booking.repositories.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserDataService {
    @Autowired
    UserDataRepo userDataRepo;

    @Autowired
    BookingService bookingService;
    public UserData save(UserData userData) {
        return userDataRepo.save(userData);

    }
    public boolean createBooking(UserData userData,Booking booking){
        return userData.getBookings().add(booking);


    }
    public Optional<UserData> getUserDataByEmail(String email){
        return userDataRepo.findByEmail(email);
    }

    public List<Room> getFreeRooms(){
        return bookingService.getFreeRooms();
    }



}

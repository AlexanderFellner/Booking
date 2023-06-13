package com.atelier04.booking.services;



import com.atelier04.booking.models.Booking;
import com.atelier04.booking.models.UserData;
import com.atelier04.booking.repositories.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDataService {
    @Autowired
    UserDataRepo userDataRepo;
    public UserData save(UserData userData) {
        return userDataRepo.save(userData);

    }
    public Booking createBooking(UserData userData,Booking booking){
        userData.getBookings().add(booking);
        return booking;
    }
    public Optional<UserData> getUserDataByEmail(String email){
        return userDataRepo.findByEmail(email);
    }



}

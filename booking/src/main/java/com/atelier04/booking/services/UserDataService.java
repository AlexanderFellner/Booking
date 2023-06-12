package com.atelier04.booking.services;



import com.atelier04.booking.models.UserData;
import com.atelier04.booking.repositories.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserDataService {
    @Autowired
    UserDataRepo userDataRepo;
    public UserData save(UserData userData) {
        return userDataRepo.save(userData);

    }



}

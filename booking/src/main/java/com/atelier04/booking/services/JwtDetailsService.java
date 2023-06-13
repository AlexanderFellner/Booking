package com.atelier04.booking.services;

import com.atelier04.booking.auth.JwtDetails;
import com.atelier04.booking.models.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtDetailsService implements UserDetailsService {
    @Autowired
    UserDataService userDataService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserData> userData=userDataService.getUserDataByEmail(email);
        if(userData.isPresent()){
            return new JwtDetails(userData.get());
        }

        return null;
    }
}

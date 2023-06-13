package com.atelier04.booking.repositories;

import com.atelier04.booking.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepo extends JpaRepository<UserData,Long> {
     Optional<UserData> findByEmail(String email);
}

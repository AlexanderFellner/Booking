package com.atelier04.booking.repositories;

import com.atelier04.booking.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepo extends JpaRepository<UserData,Long> {
}

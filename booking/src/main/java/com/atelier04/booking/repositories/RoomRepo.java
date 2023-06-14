package com.atelier04.booking.repositories;

import com.atelier04.booking.models.Lecture;
import com.atelier04.booking.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
    Optional<Room> findByName(String name);

    List<Room> findByAudio(boolean isAudio);
    List<Room> findByWhiteBoard(boolean isWhiteBoard);

    List<Room> findBySmartBoard(boolean isSmartBoard);

    List<Room> findByPrinter(boolean isPrinter);

    List<Room> findByProjector(boolean isProjector);

    List<Room> findByLecture(Lecture lecture);


}

package com.atelier04.booking.repositories;

import com.atelier04.booking.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepo extends JpaRepository<Lecture,Long> {
}
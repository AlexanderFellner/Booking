package com.atelier04.booking.services;


import com.atelier04.booking.models.Lecture;
import com.atelier04.booking.repositories.LectureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class LectureService {
    @Autowired
    LectureRepo lectureRepo;
    public List<Lecture> getLectures(){
            return lectureRepo.findAll();

    }

    public Optional<Lecture> getLectureById(@PathVariable  Long id){
            Optional<Lecture> lecture=lectureRepo.findById(id);
            return lecture;

    }

}

package com.atelier04.booking.services;


import com.atelier04.booking.models.Lecture;
import com.atelier04.booking.repositories.LectureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class LectureService {
    @Autowired
    LectureRepo lectureRepo;
    public List<Lecture> getLectures(){
            return lectureRepo.findAll();

    }

    public Optional<Lecture> getLectureById(Long id){
            return lectureRepo.findById(id);


    }
    public Lecture addLecture(LocalDateTime startLecture,LocalDateTime endLecture){

        return lectureRepo.save(Lecture.builder().startLecture(startLecture).endLecture(endLecture).build());

    }
    public void deleteLecture(Lecture lecture){
        lectureRepo.delete(lecture);
    }

}

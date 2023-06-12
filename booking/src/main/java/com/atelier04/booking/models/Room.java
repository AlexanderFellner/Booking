package com.atelier04.booking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;

    private boolean smartBoard;

    private boolean whiteBoard;

    private boolean audio;

    private boolean projector;

    private boolean printer;

    private Set<String> seats=new HashSet<>();

    private boolean section;

    private boolean country;

    private boolean directions;

    @OneToOne(mappedBy = "bookingRoom")
    private Booking booking;

    @OneToOne(mappedBy = "lectureRoom")
    private Lecture lecture;

}

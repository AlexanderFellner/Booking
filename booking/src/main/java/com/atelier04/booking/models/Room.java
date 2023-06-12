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

    private String smartBoard;

    private String whiteBoard;

    private String audio;

    private String projector;

    private String printer;

    private Set<String> seats=new HashSet<>();

    private String section;

    private String country;

    private String directions;

    @OneToOne(mappedBy = "bookingRoom")
    private Booking booking;

    @OneToOne(mappedBy = "lectureRoom")
    private Lecture lecture;

}

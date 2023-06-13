package com.atelier04.booking.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;

    @Column(name="name",unique = true)
    private String name;

    private boolean smartBoard;

    private boolean whiteBoard;

    private boolean audio;

    private boolean projector;

    private boolean printer;

    private int seats;

    private String section;


    private String category;

    private String directions;

    @OneToOne(mappedBy = "bookingRoom")
    private Booking booking;

    @OneToOne(mappedBy = "lectureRoom")
    private Lecture lecture;

}

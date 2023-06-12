package com.atelier04.booking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName = "userId")
    private UserData userData;

    @OneToOne
    @JoinColumn(name="room_id",referencedColumnName = "roomId")
    private Room bookingRoom;

    @OneToOne(mappedBy = "lectureBooking")
    private Lecture lecture;



}

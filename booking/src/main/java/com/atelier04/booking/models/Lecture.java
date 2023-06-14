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
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lectureId;

    @Column(name="name",unique = true)
    private String name;

    private LocalDateTime startLecture;

    private LocalDateTime endLecture;

    @OneToOne()
    @JoinColumn(name="roomid",referencedColumnName = "roomId")
    private Room lectureRoom;

    @OneToOne
    @JoinColumn(name="bookingid",referencedColumnName = "bookingId")
    private Booking lectureBooking;

    @OneToOne
    @JoinColumn(name="employeeid",referencedColumnName = "employeeId")
    private Employee lectureEmployee;
}

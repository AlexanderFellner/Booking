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

    private LocalDateTime startLecture;

    private LocalDateTime endLecture;

    @OneToOne()
    @JoinColumn(name="room_id",referencedColumnName = "roomId")
    private Room lectureRoom;

    @OneToOne
    @JoinColumn(name="booking_id",referencedColumnName = "bookingId")
    private Booking lectureBooking;

    @OneToOne
    @JoinColumn(name="employee_id",referencedColumnName = "employeeId")
    private Employee lectureEmployee;
}

package com.atelier04.booking.models;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    @OneToOne
    @JoinColumn(name="userIdtest",referencedColumnName = "userId")
    private UserData userStudent;

}

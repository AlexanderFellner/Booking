package com.atelier04.booking.models;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long StudentId;
    @OneToOne
    @JoinColumn(name="userIdtest",referencedColumnName = "userId")
    private UserData userStudent;

}

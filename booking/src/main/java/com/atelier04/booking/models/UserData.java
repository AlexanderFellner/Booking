package com.atelier04.booking.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Users")
public class UserData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    @Column(name="email")
    private String email;

    private String password;

    private String phoneNumber;

    @OneToOne(mappedBy = "userEmployee", cascade=CascadeType.ALL)
    private Employee employee;

    @OneToOne(mappedBy = "userStudent",cascade=CascadeType.ALL)
    private Student student;

    @OneToMany(mappedBy="userData",cascade=CascadeType.ALL)
    private Set<Booking> bookings=new HashSet<>();



}

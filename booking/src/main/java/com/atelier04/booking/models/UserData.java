package com.atelier04.booking.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
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

    @OneToOne(mappedBy = "userEmployee")
    private Employee employee;

    @OneToOne(mappedBy = "userStudent")
    private Student student;




}

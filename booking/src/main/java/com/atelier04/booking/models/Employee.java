package com.atelier04.booking.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String insurancenumber;

    @OneToOne
    @JoinColumn(name="userId",referencedColumnName = "userId")
    private UserData userEmployee;

    @OneToOne(mappedBy = "employee")
    private Admin admin;

    @OneToOne(mappedBy = "lectureEmployee")
    private Lecture lecture;


}

package com.atelier04.booking.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long EmployeeId;

    private String insurancenumber;

    @OneToOne
    @JoinColumn(name="userId",referencedColumnName = "userId")
    private UserData userEmployee;

}

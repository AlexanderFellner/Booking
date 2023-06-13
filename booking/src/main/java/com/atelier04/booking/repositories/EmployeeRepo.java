package com.atelier04.booking.repositories;

import com.atelier04.booking.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}

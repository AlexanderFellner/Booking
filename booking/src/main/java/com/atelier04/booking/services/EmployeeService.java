package com.atelier04.booking.services;

import com.atelier04.booking.models.Employee;
import com.atelier04.booking.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
       return employeeRepo.findById(id);

    }
}

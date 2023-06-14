package com.atelier04.booking.services;


import com.atelier04.booking.models.Employee;
import com.atelier04.booking.models.Lecture;
import com.atelier04.booking.models.UserData;
import com.atelier04.booking.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    private UserDataService userDataService;

    public Optional<Employee> getEmployeeById(Long id) {
       return employeeRepo.findById(id);

    }
    public Optional<Employee> getEmployeeByName(String name){
        return employeeRepo.findByName(name);
    }

    public Optional<Lecture> getLectureByEmployee(Employee employee){

          return Optional.of(employee.getLecture());

    }
    public Optional<Employee> getEmployeeByEmail(String email){
           Optional<UserData> userData=userDataService.getUserDataByEmail(email);
           if(userData.isPresent()){
               Long userId=userData.get().getUserId();
               return employeeRepo.findById(userId);
           }
           return null;
    }

}

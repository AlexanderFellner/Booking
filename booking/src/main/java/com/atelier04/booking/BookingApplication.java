package com.atelier04.booking;


import com.atelier04.booking.repositories.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
	@Autowired
	private UserDataRepo userDataRepo;
	@Override
	public void run(String... args) {



	}
}

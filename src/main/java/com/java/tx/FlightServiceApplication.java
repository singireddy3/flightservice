package com.java.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.tx.dto.FlightBookingAck;
import com.java.tx.dto.FlightBookingRequest;
import com.java.tx.service.FlightBookingService;

@SpringBootApplication
@RestController 
@EnableTransactionManagement
public class FlightServiceApplication {
	
	@Autowired
	private FlightBookingService service;
	
	
	@PostMapping("/bookFlightTicket")
	public FlightBookingAck bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return service.bookFlightTicket(request);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceApplication.class, args);
	}

	
}

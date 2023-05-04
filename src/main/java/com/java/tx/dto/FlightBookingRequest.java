package com.java.tx.dto;

import com.java.tx.entity.PassengerInfo;
import com.java.tx.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 

public class FlightBookingRequest {

	
	private PassengerInfo passengerInfo;
	
	private PaymentInfo paymentInfo; 
	
	
}

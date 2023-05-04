package com.java.tx.dto;

import com.java.tx.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAck {
	
	private String Status;
	private double totalFare;
	private String pnrno;
	private PassengerInfo passengerinfo; 
	

}

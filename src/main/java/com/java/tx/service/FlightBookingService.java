package com.java.tx.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.tx.dto.FlightBookingAck;
import com.java.tx.dto.FlightBookingRequest;
import com.java.tx.entity.PassengerInfo;
import com.java.tx.entity.PaymentInfo;
import com.java.tx.repository.PassengerInfoRepository;
import com.java.tx.repository.PaymentInfoRepository;
import com.java.tx.utils.PaymentUtils;

import jakarta.transaction.Transactional;

@Service
public class FlightBookingService {
	
	@Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAck bookFlightTicket(FlightBookingRequest request) {
    	
    	
    	PassengerInfo passengerInfo=request.getPassengerInfo();
    	passengerInfo=passengerInfoRepository.save(passengerInfo);
    	
        PaymentInfo paymentInfo = request.getPaymentInfo();
        
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAck("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    
    }

    
}

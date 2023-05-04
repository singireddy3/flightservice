package com.java.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.tx.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository <PaymentInfo,String> {
	

}

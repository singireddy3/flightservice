package com.java.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.tx.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long>{

}

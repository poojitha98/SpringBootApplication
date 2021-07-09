package com.payment.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.service.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

	 Payment findById(int orderId);
}

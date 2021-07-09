package com.payment.service.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.service.entity.Payment;
import com.payment.service.repository.PaymentRepository;

@Service
public class PaymentService {
 
	@Autowired
	private PaymentRepository repo;
	
	public Payment savePayment(Payment payment) {
		payment.setPaymentstatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return repo.save(payment);
		
	}
	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}
	
	public Payment findPaymentHistoryById(int orderId) {
		// TODO Auto-generated method stub
		return repo.findById(orderId);
	}
	
}

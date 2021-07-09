package com.test.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.orderservice.common.Payment;
import com.test.orderservice.common.TransactionRequest;
import com.test.orderservice.common.TransactionResponse;
import com.test.orderservice.entity.Orders;
import com.test.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository Repository;
	@Autowired
	RestTemplate restTemplate;

	public TransactionResponse makeOrder(TransactionRequest request) {
		String response = "";
		System.out.println("order is::" + request.getOrder().getId());
		System.out.println("order is::" + request.getOrder().getName());
		System.out.println("order is::" + request.getOrder().getPrice());
		System.out.println("order is::" + request.getOrder().getQty());
		System.out.println("payment is::" + request.getPayment().getAmount());
		System.out.println("payment is::" + request.getPayment().getOrderid());
		System.out.println("payment is::" + request.getPayment().getPaymentId());
		System.out.println("payment is::" + request.getPayment().getPaymentstatus());
		System.out.println("payment is::" + request.getPayment().getTransactionId());
		Orders order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setPaymentId(order.getId());
		payment.setOrderid(order.getId());
		payment.setAmount(order.getPrice());
		System.out.println("payment1 is::" + payment.getAmount());
		System.out.println("payment1 is::" + payment.getOrderid());
		System.out.println("payment is::" + payment.getPaymentId());
		System.out.println("payment is::" + payment.getPaymentstatus());
		System.out.println("payment is::" + payment.getTransactionId());
		System.out.println(payment.toString());
		Payment paymentresponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/postPayment", payment,
				Payment.class);
		// return Repository.save(order);
		System.out.println("paymentresponse is::" + paymentresponse.getAmount());
		System.out.println("paymentresponse is::" + paymentresponse.getOrderid());
		System.out.println("paymentresponse is::" + paymentresponse.getPaymentId());
		System.out.println("paymentresponse is::" + paymentresponse.getPaymentstatus());
		System.out.println("paymentresponse is::" + paymentresponse.getTransactionId());
		response = paymentresponse.getPaymentstatus().equals("success")
				? "payment processing successfull and order placed"
				: "There is a failure in payment,order api added to cart";
		System.out.println(response);
		TransactionResponse res=new TransactionResponse(order, paymentresponse.getTransactionId(), paymentresponse.getAmount(),
				response);
		System.out.println(res.toString());
		System.out.println(res);
		return res;

	}
}
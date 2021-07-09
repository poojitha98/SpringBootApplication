package com.test.orderservice.common;

import org.json.JSONObject;

import com.test.orderservice.entity.Orders;

public class TransactionResponse {
	private Orders order;
	private String transactionId;
	private double amount;
	private String message;
	public TransactionResponse(Orders order, String transactionId, double amount, String message) {
		this.order = order;
		this.transactionId = transactionId;
		this.amount = amount;
		this.message = message;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	

}

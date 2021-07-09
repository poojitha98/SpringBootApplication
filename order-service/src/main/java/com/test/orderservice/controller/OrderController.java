package com.test.orderservice.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.orderservice.common.Payment;
import com.test.orderservice.common.TransactionRequest;
import com.test.orderservice.common.TransactionResponse;
import com.test.orderservice.entity.Orders;
import com.test.orderservice.service.OrderService;

//mark class as Controller
@RestController
@RequestMapping("/order")
public class OrderController 
{
//autowire the orderService class
@Autowired
OrderService orderService;
//creating a get mapping that retrieves all the order detail from the database 

@PostMapping("/makeOrder")
public String makeOrder(@RequestBody TransactionRequest request) {
	TransactionResponse res=orderService.makeOrder(request);
	return res.toString();
}


}

	


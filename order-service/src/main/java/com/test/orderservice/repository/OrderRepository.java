package com.test.orderservice.repository;

import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository

import com.test.orderservice.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer>
{
}

package com.qeema.service;

import java.util.List;
import java.util.Optional;

import com.qeema.dto.OrderDto;

public interface OrderService {

	public List<OrderDto> findAll();
	public Optional<OrderDto> findById(long orderNo);
	public void saveOrUpdate(OrderDto orderDto);
	public void deleteById(long orderNo);

}

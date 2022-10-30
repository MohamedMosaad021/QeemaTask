package com.qeema.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qeema.dto.OrderDto;
import com.qeema.entity.Order;
import com.qeema.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<OrderDto> findAll() {
		List<Order> OrdersList = orderRepository.findAll();
		List<OrderDto> OrderDtoList = new ArrayList<>();
		OrdersList.forEach(order -> {
			OrderDto orderDto = new OrderDto();
			BeanUtils.copyProperties(order, orderDto);
			OrderDtoList.add(orderDto);
		});

		return OrderDtoList;
	}

	@Override
	public Optional<OrderDto> findById(long orderNo) {
		Optional<Order> optionalOrder = orderRepository.findById(orderNo);
		OrderDto orderDto = new OrderDto();
		BeanUtils.copyProperties(optionalOrder, orderDto);
		return Optional.ofNullable(orderDto);
	}

	@Override
	public void saveOrUpdate(OrderDto orderDto) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDto, order);
		orderRepository.save(order);
	}

	@Override
	public void deleteById(long orderNo) {
		orderRepository.deleteById(orderNo);
	}

}

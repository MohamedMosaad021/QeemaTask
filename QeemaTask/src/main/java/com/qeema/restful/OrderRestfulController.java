package com.qeema.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qeema.dto.OrderDto;
import com.qeema.dto.ProductDto;
import com.qeema.exception.ResourceNotFoundException;
import com.qeema.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderRestfulController {

	@Autowired
	OrderService orderService;

	@GetMapping("/findAll")
	public ResponseEntity<List<OrderDto>> findAll() {
		List<OrderDto> orderDtoList = orderService.findAll();
		if (orderDtoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
	}

	@GetMapping("/findById/{orderNo}")
	public ResponseEntity<OrderDto> findById(@PathVariable long orderNo) {
		OrderDto orderDto = orderService.findById(orderNo)
				.orElseThrow(() -> new ResourceNotFoundException("Not found product with id = " + orderNo));
		return new ResponseEntity<>(orderDto, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ProductDto> save(@RequestBody OrderDto orderDto) {
		orderService.saveOrUpdate(orderDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<ProductDto> update(@RequestBody OrderDto orderDto) {
		orderService.saveOrUpdate(orderDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

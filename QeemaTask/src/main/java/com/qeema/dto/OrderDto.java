package com.qeema.dto;

public class OrderDto {

	private String orderDate;
	private Long cost;

	public OrderDto() {
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

}

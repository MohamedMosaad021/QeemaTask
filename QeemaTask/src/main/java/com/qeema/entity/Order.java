package com.qeema.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "SEC_ORDER", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEC_ORDER", sequenceName = "SEC_ORDER",allocationSize=1)
	@Basic(optional = false)
	@NotNull
	@Column(name = "ORDER_NO")
	private Long orderNo;
	@Size(max = 20)
	@Column(name = "ORDER_DATE")
	private String orderDate;
	@Column(name = "COST")
	private Long cost;
	@JoinTable(name = "ORDERS_PRODUCT", joinColumns = {
			@JoinColumn(name = "ORDER_NO", referencedColumnName = "ORDER_NO") }, inverseJoinColumns = {
					@JoinColumn(name = "PRODUCT_NO", referencedColumnName = "PRODUCT_NO") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Product> productList;

	public Order() {
	}

	public Order(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
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


	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}

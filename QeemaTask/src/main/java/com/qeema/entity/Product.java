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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "SEC_PRODUCT", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEC_PRODUCT", sequenceName = "SEC_PRODUCT",allocationSize=1)
	@Basic(optional = false)
	@NotNull
	@Column(name = "PRODUCT_NO")
	private Long productNo;
	@Size(max = 50)
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRICE")
	private Long price;
	@Column(name = "QUANTITY")
	private Long quantity;
	@ManyToMany(mappedBy = "productList", fetch = FetchType.LAZY)
	private List<Order> ordersList;

	public Product() {
	}

	public Product(Long productNo) {
		this.productNo = productNo;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public List<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}
}

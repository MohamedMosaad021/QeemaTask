package com.qeema.service;

import java.util.List;
import java.util.Optional;

import com.qeema.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> findAll();
	public Optional<ProductDto> findById(long productNo);
	public void saveOrUpdate(ProductDto productDto);
	public void deleteById(long productNo);
}

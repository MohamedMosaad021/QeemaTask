package com.qeema.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qeema.dto.ProductDto;
import com.qeema.entity.Product;
import com.qeema.repository.ProductRepository;

@Service
public class ProductserviceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductDto> findAll() {
		List<Product> productList = productRepository.findAll();
		List<ProductDto> productDtoList = new ArrayList<>();

		productList.forEach(product -> {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			productDtoList.add(productDto);
		});
		return productDtoList;
	}

	@Override
	public void saveOrUpdate(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		productRepository.save(product);
	}

	@Override
	public void deleteById(long productNo) {
		productRepository.deleteById(productNo);
	}

	@Override
	public Optional<ProductDto> findById(long productNo) {
		 Optional<Product> product = productRepository.findById(productNo);
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return Optional.ofNullable(productDto);
	}

}

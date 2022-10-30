package com.qeema.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qeema.dto.ProductDto;
import com.qeema.exception.ResourceNotFoundException;
import com.qeema.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestfulController {

	@Autowired
	ProductService productService;

	@GetMapping("/findAll")
	public ResponseEntity<List<ProductDto>> findAll() {
		List<ProductDto> productDtoList = productService.findAll();
		if (productDtoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/findById/{productNo}")
	public ResponseEntity<ProductDto> findById(@PathVariable long productNo) {
		ProductDto productDto = productService.findById(productNo)
				.orElseThrow(() -> new ResourceNotFoundException("Not found product with id = " + productNo));
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
		productService.saveOrUpdate(productDto);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
		productService.saveOrUpdate(productDto);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/deleteById/{productNo}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable long productNo) {
		productService.deleteById(productNo);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

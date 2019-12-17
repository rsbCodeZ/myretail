package com.target.myretail;

import com.target.myretail.price.beans.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myretail")
@RequiredArgsConstructor
public class WebController {

	private final RetailService retailService;

	@GetMapping("/products/{id}")
	public ResponseEntity<Response> getProductWithPrice(@PathVariable String id) {

		return ResponseEntity.status(HttpStatus.OK).body(retailService.getProductWithPrice(id));
	}

	@PostMapping("/products/{id}/price")
	public ResponseEntity createProductPrice(@PathVariable String id, @RequestBody Price price) {

		retailService.createProductPrice(id, price);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/products/{id}/price")
	public ResponseEntity updateProductPrice(@PathVariable String id, @RequestBody Price price) {

		retailService.updateProductPrice(id, price);
		return ResponseEntity.status(HttpStatus.OK).build();
	}


}

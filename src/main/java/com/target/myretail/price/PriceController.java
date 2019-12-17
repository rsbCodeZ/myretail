package com.target.myretail.price;

import com.target.myretail.price.beans.Price;
import java.util.Optional;
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
@RequestMapping("/price-api")
@RequiredArgsConstructor
public class PriceController {

	private final PriceService priceService;

	@GetMapping("/products/{id}/price")
	public Optional<Price> getPrice(@PathVariable String id) {

		return priceService.getPrice(id);
	}

	@PostMapping("/products/{id}/price")
	public ResponseEntity createPrice(@PathVariable String id, @RequestBody Price price) {

		priceService.createPrice(id, price);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/products/{id}/price")
	public ResponseEntity updatePrice(@PathVariable String id, @RequestBody Price price) {

		priceService.updatePrice(id, price);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

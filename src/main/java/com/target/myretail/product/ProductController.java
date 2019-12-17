package com.target.myretail.product;

import com.target.myretail.product.beans.Product;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-api")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("/products/{id}/info")
	public Optional<Product> getProduct(@PathVariable String id) {

		return productService.getProduct(id);
	}
}

package com.target.myretail.product;

import com.target.myretail.product.beans.Product;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	public Optional<Product> getProduct(String productId) {

		return Optional.ofNullable(ProductLoader.productData.get(productId));
	}
}

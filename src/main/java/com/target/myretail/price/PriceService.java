package com.target.myretail.price;

import com.target.myretail.exception.ApiException;
import com.target.myretail.exception.ResourceNotFound;
import com.target.myretail.price.beans.Price;
import com.target.myretail.product.beans.Product;
import com.target.myretail.util.ApiCaller;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

	private final ApiCaller apiCaller;

	@Value("${price.url}")
	private String PRICE_API;

	@Value("${product.url}")
	private String PRODUCT_API;


	public Optional<Price> getPrice(String productId) {

		return Optional.ofNullable(PriceLoader.priceData.get(productId));
	}

	public void updatePrice(String productId, Price price) {

		getProductFromApi(productId);
		PriceLoader.priceData.put(productId, price);
	}

	public void createPrice(String productId, Price price) {

		getProductFromApi(productId);

		if (!isPricePresent(productId)) {
			PriceLoader.priceData.put(productId, price);
		} else {
			throw new ApiException("Price is already created, try to update");
		}
	}

	private Product getProductFromApi(String productId) {

		return Optional.ofNullable(apiCaller.callApi(PRODUCT_API, productId, Product.class))
				.orElseThrow(() -> new ResourceNotFound("Not found Product : " + productId));
	}

	private boolean isPricePresent(String productId) {

		Optional<Price> price = Optional.ofNullable(apiCaller.callApi(PRICE_API, productId, Price.class));
		return price.isPresent();
	}

}

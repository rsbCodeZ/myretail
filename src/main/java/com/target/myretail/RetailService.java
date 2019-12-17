package com.target.myretail;

import com.target.myretail.exception.ApiException;
import com.target.myretail.exception.ResourceNotFound;
import com.target.myretail.price.beans.Price;
import com.target.myretail.product.beans.Product;
import com.target.myretail.util.ApiCaller;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
@RequiredArgsConstructor
public class RetailService {

	private final ApiCaller apiCaller;

	@Value("${price.url}")
	private String PRICE_API;

	@Value("${product.url}")
	private String PRODUCT_API;

	public Response getProductWithPrice(String productId) {

		try {
			return CompletableFuture.supplyAsync(() -> Optional.ofNullable(apiCaller.callApi(PRODUCT_API, productId, Product.class)))
					.thenCombine(CompletableFuture.supplyAsync(() -> Optional.ofNullable(apiCaller.callApi(PRICE_API, productId, Price.class))),
							(product, price) -> {
								product.orElseThrow(() -> new ResourceNotFound("Not found Product : " + productId));
								price.orElseThrow(() -> new ResourceNotFound("Price not found for product : " + productId));
								return Response.builder().id(productId).name(product.get().getName()).currentPrice(price.get()).build();
							})
					.get();
		} catch (InterruptedException | ExecutionException exception) {
			throw new ApiException(exception.getMessage(), exception);
		}
	}


	public void createProductPrice(String productId, Price price) {

		try {
			apiCaller.postApi(PRICE_API, price, Price.class, productId);
		} catch (RestClientException exception) {
			throw new ApiException(exception.getMessage(), exception);
		}
	}

	public void updateProductPrice(String productId, Price price) {

		try {
			apiCaller.putApi(PRICE_API, price, productId);
		} catch (RestClientException exception) {
			throw new ApiException(exception.getMessage(), exception);
		}
	}

}

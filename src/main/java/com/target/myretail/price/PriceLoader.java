package com.target.myretail.price;

import com.target.myretail.price.beans.Price;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class PriceLoader {

	public static Map<String, Price> priceData = new HashMap<>();

	@PostConstruct
	public static void loadPrice() {

		priceData.put("15117729", Price.builder().amount(BigDecimal.valueOf(13.49)).currencyCode(CurrencyCode.USD).build());
		priceData.put("15117730", Price.builder().amount(BigDecimal.valueOf(20.49)).currencyCode(CurrencyCode.USD).build());
		priceData.put("15117731", Price.builder().amount(BigDecimal.valueOf(16.00)).currencyCode(CurrencyCode.USD).build());
		priceData.put("15117732", Price.builder().amount(BigDecimal.valueOf(23.50)).currencyCode(CurrencyCode.USD).build());
		priceData.put("15117733", Price.builder().amount(BigDecimal.valueOf(11.25)).currencyCode(CurrencyCode.USD).build());
		priceData.put("15117734", Price.builder().amount(BigDecimal.valueOf(14.50)).currencyCode(CurrencyCode.USD).build());
	}
}

package com.target.myretail.price.beans;

import com.target.myretail.price.CurrencyCode;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Price {

	private CurrencyCode currencyCode;
	private BigDecimal amount;
}

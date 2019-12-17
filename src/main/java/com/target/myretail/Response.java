package com.target.myretail;

import com.target.myretail.price.beans.Price;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

	private String id;
	private String name;
	private Price currentPrice;
}

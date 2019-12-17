package com.target.myretail.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.myretail.exception.ApiException;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String toJsonString(Object object) {

		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}

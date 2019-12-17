package com.target.myretail.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiCaller {

	private final RestTemplate restTemplate;

	public <T> T callApi(String endpoint, String id, Class<T> responseType) {

		log.info(HttpMethod.GET + ", endpoint : " + endpoint + ", id : " + id);

		return restTemplate.getForObject(endpoint, responseType, id);
	}

	public <T> T postApi(String url, T request, Class<T> requestType, Object uriVars) {

		log.info(HttpMethod.POST + ", endpoint : " + url + ", requestBody : " + JsonUtil.toJsonString(request));

		return restTemplate.postForObject(url, request, requestType, uriVars);
	}

	public void putApi(String url, Object object, Object uriVars) {

		log.info(HttpMethod.PUT + ", endpoint : " + url + ", requestBody : " + JsonUtil.toJsonString(object));

		restTemplate.put(url, object, uriVars);
	}
}

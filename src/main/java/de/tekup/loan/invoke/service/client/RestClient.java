package de.tekup.loan.invoke.service.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.tekup.loan.invoke.ui.CustomerRequest;
import de.tekup.loan.invoke.ui.WsResponse;

@Service
public class RestClient {
	
	public static final String URL = "http://localhost:8080/api/get-status";
	private RestTemplate restTemplate = new RestTemplate();
	
	public WsResponse getLoanStatus(CustomerRequest request) {
		// call of the service
		WsResponse response = restTemplate.postForObject(URL, request, WsResponse.class);
		
		return response;
	}

}

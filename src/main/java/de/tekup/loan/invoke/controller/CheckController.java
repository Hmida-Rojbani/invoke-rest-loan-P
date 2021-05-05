package de.tekup.loan.invoke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.invoke.service.client.RestClient;
import de.tekup.loan.invoke.service.client.RestClientFeign;
import de.tekup.loan.invoke.ui.CustomerRequest;
import de.tekup.loan.invoke.ui.WsResponse;

@Controller
public class CheckController {
	
	@Autowired
	private RestClient client;
	// alternative way (feign)
	@Autowired
	private RestClientFeign feignClient;
	
	@GetMapping("/check/customer")
	public String checkCustomerForm(Model model) {
		CustomerRequest  request = new CustomerRequest();
		request.setCibilScore(500);
		model.addAttribute("request", request);
		return "request";
	}
	
	@PostMapping("/check/customer")
	public String checkCustomerWS(@ModelAttribute("request") CustomerRequest request, Model model) {
		// call of the service (rest api)
		//WsResponse response = client.getLoanStatus(request);
		// other way
		WsResponse response = feignClient.consumeFeign(request);
		model.addAttribute("response", response);
		return "response";
	}

}

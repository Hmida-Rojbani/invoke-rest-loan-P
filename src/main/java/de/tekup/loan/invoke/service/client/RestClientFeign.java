package de.tekup.loan.invoke.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import de.tekup.loan.invoke.ui.CustomerRequest;
import de.tekup.loan.invoke.ui.WsResponse;

@FeignClient(url = "localhost:8080", value = "localhost:8080")
public interface RestClientFeign {
	
	@PostMapping(path = "/api/get-status")
	public WsResponse consumeFeign(@RequestBody CustomerRequest request);

}

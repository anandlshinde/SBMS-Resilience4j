package com.smtek.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class OrderRestController {
	
	
	
	private static final String ORDER_SERVICE = "orderService";
	@Autowired
	private RestTemplate restTemplate;
	//http://localhost:8181/itemService/item/watch

	@GetMapping("/order/{itemName}")
	@CircuitBreaker(name =ORDER_SERVICE,fallbackMethod = "orderFallback" )
	public ResponseEntity<String> placeOrder(@PathVariable String itemName){
		String responseObj = restTemplate.getForObject("http://127.0.0.1:8181/itemService/item/"+itemName, String.class);
		return new ResponseEntity<String>(responseObj,HttpStatus.OK);
	}
	
	public ResponseEntity<String> orderFallback(Exception e){
		return new ResponseEntity<String>("Temprary Item Service Down",HttpStatus.OK);
	}
}

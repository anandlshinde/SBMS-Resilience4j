package com.smtek.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemRestController {

	
	@GetMapping("/item/{name}")
	public ResponseEntity<String> getItems(@PathVariable String name){
		return new ResponseEntity<String>(name,HttpStatus.FOUND);
	}
}

package com.playsafe.conversion.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.conversions.endpoint}")
public class ConversionController {
	@PostMapping("ktoc")
	public ResponseEntity<?> ktoc(double kelvin){
		double celcius = kelvin - 273.15;
		return ResponseEntity.ok(celcius);
	}
}

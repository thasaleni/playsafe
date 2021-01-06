package com.playsafe.conversion.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.conversions.endpoint}")
public class ConversionController {
  @PostMapping("ktoc")
  public ResponseEntity<?> ktoc(@RequestBody(required=false) Double kelvin) {
    if (kelvin == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Kelvin value is required.");
    }
    double celcius = kelvin - 273.15;
    return ResponseEntity.ok(celcius);
  }

  @PostMapping("ctok")
  public ResponseEntity<?> ctok(@RequestBody(required=false) Double celcius) {
    if (celcius == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("celcius value is required.");
    }
    double kelvin = celcius + 273.15;
    return ResponseEntity.ok(kelvin);
  }

  @PostMapping("mtok")
  public ResponseEntity<?> mtok(@RequestBody(required=false) Double miles) {
    if (miles == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Miles value is required.");
    }
    double kilometers = miles * 1.609;
    return ResponseEntity.ok(kilometers);
  }

  @PostMapping("ktom")
  public ResponseEntity<?> ktom(@RequestBody(required = false) Double kilometers) {
    if (kilometers == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Kilometers value is required.");
    }
    double miles = kilometers / 1.609;
    return ResponseEntity.ok(miles);
  }
}

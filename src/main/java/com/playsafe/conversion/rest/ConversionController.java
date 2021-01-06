package com.playsafe.conversion.rest;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("${app.conversions.endpoint}")
public class ConversionController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ConversionController.class);

  @PostMapping("ktoc")
  public ResponseEntity<?> ktoc(@RequestBody(required = false) Double kelvin) {
    Instant start = Instant.now();
    if (kelvin == null) {
      Instant end = Instant.now();
      LOGGER.info("ktoc duration: " + Duration.between(start, end).getNano()+"ms");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Kelvin value is required.");
    }
    double celcius = kelvin - 273.15;
    Instant end = Instant.now();
    LOGGER.info("ktoc duration: " + Duration.between(start, end).getNano()+"ms");
    return ResponseEntity.ok(celcius);
  }

  @PostMapping("ctok")
  public ResponseEntity<?> ctok(@RequestBody(required = false) Double celcius) {
    Instant start = Instant.now();
    if (celcius == null) {
      Instant end = Instant.now();
      LOGGER.info("ctok duration: " + Duration.between(start, end));
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("celcius value is required.");
    }
    double kelvin = celcius + 273.15;
    Instant end = Instant.now();
    LOGGER.info("ctok duration: " + Duration.between(start, end).getNano()+"ms");
    return ResponseEntity.ok(kelvin);
  }

  @PostMapping("mtok")
  public ResponseEntity<?> mtok(@RequestBody(required = false) Double miles) {
    Instant start = Instant.now();
    if (miles == null) {
      Instant end = Instant.now();
      LOGGER.info("mtok duration: " + Duration.between(start, end));
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Miles value is required.");
    }
    double kilometers = miles * 1.609;
    Instant end = Instant.now();
    LOGGER.info("mtok duration: " + Duration.between(start, end).getSeconds()+"s");
    return ResponseEntity.ok(kilometers);
  }

  @PostMapping("ktom")
  public ResponseEntity<?> ktom(@RequestBody(required = false) Double kilometers) {
    Instant start = Instant.now();
    if (kilometers == null) {
      Instant end = Instant.now();
      LOGGER.info("ktom duration: " + Duration.between(start, end));
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Kilometers value is required.");
    }
    double miles = kilometers / 1.609;
    Instant end = Instant.now();
    LOGGER.info("ktom duration: " + Duration.between(start, end));
    return ResponseEntity.ok(miles);
  }
}

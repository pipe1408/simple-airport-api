package com.felipe.airportapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<HttpStatus> healthCheck() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

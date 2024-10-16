package org.example.assignment02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/HealthCheck")
public class HealthCheck {
    @GetMapping
    public String healthCheck() {
        return "OK";
    }
}

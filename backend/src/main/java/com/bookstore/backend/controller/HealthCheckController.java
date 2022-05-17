package com.bookstore.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/")
    public String healthCheck() {
        return "컨트롤러 연결 성공";
    }
}

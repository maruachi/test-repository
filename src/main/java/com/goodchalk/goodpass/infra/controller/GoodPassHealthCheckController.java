package com.goodchalk.goodpass.infra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodPassHealthCheckController {
    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }
}

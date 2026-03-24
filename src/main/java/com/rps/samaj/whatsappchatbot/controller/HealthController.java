package com.rps.samaj.whatsappchatbot.controller;

import com.rps.samaj.whatsappchatbot.dto.HealthStatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<HealthStatusResponse> health() {
        HealthStatusResponse body = new HealthStatusResponse("UP", "whatsapp-chatbot-simulation");
        return ResponseEntity.ok(body);
    }
}

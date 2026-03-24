package com.rps.samaj.whatsappchatbot.controller;

import com.rps.samaj.whatsappchatbot.dto.WebhookMessageRequest;
import com.rps.samaj.whatsappchatbot.dto.WebhookReplyResponse;
import com.rps.samaj.whatsappchatbot.service.ChatbotReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private static final Logger log = LoggerFactory.getLogger(WebhookController.class);

    private final ChatbotReplyService chatbotReplyService;

    public WebhookController(ChatbotReplyService chatbotReplyService) {
        this.chatbotReplyService = chatbotReplyService;
    }

    @PostMapping("/webhook")
    public ResponseEntity<WebhookReplyResponse> webhook(@RequestBody WebhookMessageRequest message) {
        String userText = message.getMessageText();
        log.info("Incoming message: from={}, text={}", message.getFrom(), userText);

        String replyText = chatbotReplyService.replyTo(userText);
        WebhookReplyResponse resp = new WebhookReplyResponse(message.getFrom(), replyText);

        log.info("Reply: to={}, text={}", resp.getTo(), resp.getReply());
        return ResponseEntity.ok(resp);
    }
}

package com.rps.samaj.whatsappchatbot.service;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ChatbotReplyService {

    public String replyTo(String messageBody) {
        if (messageBody == null || messageBody.isBlank()) {
            return "Send a text message to chat.";
        }
        String key = messageBody.toLowerCase(Locale.ROOT).trim();
        if ("hi".equals(key)) {
            return "Hello";
        }
        if ("bye".equals(key)) {
            return "Goodbye";
        }
        return "Sorry, I only understand Hi and Bye for now.";
    }
}

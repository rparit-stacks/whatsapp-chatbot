package com.rps.samaj.whatsappchatbot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookMessageRequest {

    private String from;
    private String text;

    public String getMessageText() {
        if (text == null || text.isBlank()) {
            return "";
        }
        return text.trim();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

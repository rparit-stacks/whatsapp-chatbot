package com.rps.samaj.whatsappchatbot.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChatbotReplyServiceTest {

    private final ChatbotReplyService service = new ChatbotReplyService();

    @Test
    void hiCaseInsensitive() {
        assertThat(service.replyTo("HI")).isEqualTo("Hello");
        assertThat(service.replyTo("  hi  ")).isEqualTo("Hello");
    }

    @Test
    void byeReturnsGoodbye() {
        assertThat(service.replyTo("bye")).isEqualTo("Goodbye");
    }

    @Test
    void blankMessageGetsPrompt() {
        assertThat(service.replyTo("   ")).isEqualTo("Send a text message to chat.");
    }
}

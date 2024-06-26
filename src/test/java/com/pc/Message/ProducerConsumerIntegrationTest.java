package com.pc.Message;

import com.pc.dto.message.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class ProducerConsumerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BlockingQueue<Message> messageQueue;

    @Test
    public void testSendMessageAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/producer/send")
                        .content("Test Message"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        assertEquals(1, messageQueue.size());
    }
}


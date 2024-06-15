package com.pc.config;

import com.pc.dto.message.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Configuration
public class AppConfig {

    @Bean
    public BlockingQueue<Message> messageQueue() {
        return new ArrayBlockingQueue<>(10); // Adjust the capacity as needed
    }
}

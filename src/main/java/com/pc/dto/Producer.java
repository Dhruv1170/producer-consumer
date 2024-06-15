package com.pc.dto;


import com.pc.dto.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;

@Component
@Slf4j
public class Producer implements Runnable {
    private BlockingQueue<Message> queue;
    private int totalMessages;
    private int errorCount;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
        this.totalMessages = 0;
        this.errorCount = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String messageContent = generateMessage(); // Simulate message generation
                Message message = new Message(messageContent);

                if (sendMessage(message)) {
                    totalMessages++;
                } else {
                    errorCount++;
                }

                Thread.sleep(1000); // Simulate time between messages
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private String generateMessage() {
        // Generate message content (for simulation purposes)
        return "Message #" + System.currentTimeMillis();
    }

    public boolean sendMessage(Message message) {
        try {
            queue.put(message);
            log.info("message processed successfully :: {} :: ");
            return true;
        } catch (InterruptedException e) {
            log.error("exception occurred while processing :: {} ::");
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public int getTotalMessages() {
        return totalMessages;
    }

    public int getErrorCount() {
        return this.errorCount;
    }
}

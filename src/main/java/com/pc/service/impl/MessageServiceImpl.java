package com.pc.service.impl;

import com.pc.dto.Producer;
import com.pc.dto.message.Message;
import com.pc.dto.message.MessageResponse;
import com.pc.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    final BlockingQueue<Message> messageQueue;
    final Producer producer;

    @Override
    public MessageResponse sendMessage(String message) {
        try {
            log.info("sendMessage() called :: {} :: message is processing ");
            Message msg = new Message(message);
            producer.sendMessage(msg);
            return new MessageResponse(producer.getTotalMessages(), producer.getErrorCount());
        } catch (Exception e) {
            log.error("exception occurred while processing message :: {} :: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

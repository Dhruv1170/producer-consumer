package com.pc.controller;


import com.pc.dto.message.MessageResponse;
import com.pc.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class MessageController {

    final MessageService messageService;

    @PostMapping("/send")
    public MessageResponse sendMessage(@RequestBody String message) {
        return messageService.sendMessage(message);
    }
}

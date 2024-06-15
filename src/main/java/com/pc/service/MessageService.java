package com.pc.service;

import com.pc.dto.message.MessageResponse;

public interface MessageService {
    MessageResponse sendMessage(String message);
}

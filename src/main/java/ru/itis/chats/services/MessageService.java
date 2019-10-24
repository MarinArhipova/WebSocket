package ru.itis.chats.services;

import ru.itis.chats.dto.MessageDto;
import ru.itis.chats.models.Message;

import java.util.List;

public interface MessageService {
    void save(MessageDto text);
    List<Message> getAllMessages();
}

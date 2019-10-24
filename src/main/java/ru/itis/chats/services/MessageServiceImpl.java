package ru.itis.chats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.chats.dto.MessageDto;
import ru.itis.chats.models.Message;
import ru.itis.chats.models.User;
import ru.itis.chats.repositories.MessageRepository;
import ru.itis.chats.repositories.UserRepository;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void save(MessageDto messageDto) {
        User user = userRepository.findByUsername(messageDto.getFrom()).get();

        Message message = Message.builder()
                .text(messageDto.getText())
                .author(user)
                .build();
        messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}

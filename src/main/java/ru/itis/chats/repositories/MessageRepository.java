package ru.itis.chats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.chats.models.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {
}

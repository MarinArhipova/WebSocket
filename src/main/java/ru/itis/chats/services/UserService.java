package ru.itis.chats.services;

import ru.itis.chats.dto.UserDto;
import ru.itis.chats.forms.SignInForm;
import ru.itis.chats.models.User;

import java.util.Optional;

public interface UserService {
    UserDto signUp(String username);
    Optional<User> findByUsername(String username);
}

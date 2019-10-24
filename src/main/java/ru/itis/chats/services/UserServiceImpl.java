package ru.itis.chats.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.chats.dto.UserDto;
import ru.itis.chats.forms.SignInForm;
import ru.itis.chats.models.Role;
import ru.itis.chats.models.User;
import ru.itis.chats.repositories.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public UserDto signUp(String username) {
        User user = User.builder()
                .username(username)
                .role(Role.USER)
                .build();
        usersRepository.save(user);

        Map<String, Object> claims = new HashMap<>();

        claims.put("userId", user.getId());
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole().toString());

        String token = Jwts.builder().setClaims(claims)
                .setSubject(user.getId().toString())
                .setId(claims.get("userId").toString())
                .signWith(SignatureAlgorithm.HS512, secret).compact();

        return UserDto.builder()
                .username(user.getUsername())
                .token(token)
                .role(user.getRole())
                .build();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}

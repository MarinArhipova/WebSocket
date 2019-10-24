package ru.itis.chats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.chats.dto.UserDto;
import ru.itis.chats.forms.SignInForm;
import ru.itis.chats.services.UserService;

import java.util.UUID;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in";
    }

    @PostMapping(value = "/signIn")
    public String signIn(@RequestParam(name = "username") String username) {
        userService.signUp(username);
            return "redirect:/chat";
    }

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("id", UUID.randomUUID().toString());
        return "index_web_sockets";
    }
}

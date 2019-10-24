//package ru.itis.chats.controllers;
//
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import ru.itis.chats.forms.SignInForm;
//import ru.itis.chats.services.UserService;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class AuthController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping(value = "/registration")
//    public String getRegistrationPage() {
//        return "registration";
//    }
//
//
//    @PostMapping("/registration")
//    public String signUp(SignInForm userForm) {
//        userService.signUp(userForm);
//        return "redirect:/login";
//    }
//
//    @GetMapping(value = "/login")
//    public String getLoginPage(HttpServletRequest request, Authentication authentication, ModelMap model) {
//        if (authentication != null) {
//            return "redirect:/chat";
//        }
//        if (request.getParameterMap().containsKey("error")) {
//            model.addAttribute("error", "Неверный логин или пароль");
//        }
//        return "login";
//    }
//
//
//}

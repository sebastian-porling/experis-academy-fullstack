package se.experis.academy.gradle_on_heroku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.experis.academy.gradle_on_heroku.model.User;
import se.experis.academy.gradle_on_heroku.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("message", "Please enter valid email!");
        model.addAttribute("user", new User().setEmail(""));
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        if(!user.isValid()){
            model.addAttribute("message", "Not valid email address!");
            return "register";
        }
        if (!userRepository.existsByEmail(user.getEmail())) {
            model.addAttribute("user", userRepository.save(user));
            return "registered";
        }
        model.addAttribute("message", "Email already exists!");
        return "register";
    }

    @GetMapping("/registered")
    public String registered(@ModelAttribute User user, Model model) {
        if (user == null || user.getEmail() == null) {
            return "redirect:/register";
        }
        model.addAttribute("user", user);
        return "registered";
    }
}

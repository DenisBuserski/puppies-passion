package com.puppiespassion.web;

import com.puppiespassion.model.dto.UserRegistrationDTO;
import com.puppiespassion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/user/registration")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/form")
    public String registrationForm() {
        return "registration.html";
    }

    @PostMapping("/form")
    public String register(UserRegistrationDTO userRegistrationDTO, Model model) {
        model.addAttribute("username", userRegistrationDTO.getUsername());
        model.addAttribute("password", userRegistrationDTO.getPassword());
        model.addAttribute("confirmationPassword", userRegistrationDTO.getConfirmPassword());
        model.addAttribute("email", userRegistrationDTO.getEmail());
        model.addAttribute("firstName", userRegistrationDTO.getFirstName());
        model.addAttribute("lastName", userRegistrationDTO.getLastName());
        model.addAttribute("gender", userRegistrationDTO.getGender());

        this.userService.register(userRegistrationDTO);

        return "redirect:/user/registration/form";
    }

}

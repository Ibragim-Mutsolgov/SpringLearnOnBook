package com.example.springlearnonbook.controller;

import com.example.springlearnonbook.domain.RegistrationForm;
import com.example.springlearnonbook.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String register(){
        return "registration";
    }

    @PostMapping
    public String addUser(RegistrationForm form){
        usersRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}

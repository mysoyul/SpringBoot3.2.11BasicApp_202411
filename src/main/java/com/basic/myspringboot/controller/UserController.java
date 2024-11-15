package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.UserEntity;
import com.basic.myspringboot.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/thymeleaf")
    public String leaf(Model model) {
        model.addAttribute("name", "스프링부트");
        return "leaf";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(@ModelAttribute("user") UserEntity user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid @ModelAttribute("user") UserEntity user,
                          BindingResult result, Model model) {
        //입력항목 검증 오류가 발생했어?
        if (result.hasErrors()) {
            return "add-user";
        }
        userRepository.save(user);
//        model.addAttribute("users", userRepository.findAll());
//        return "index";
        return "redirect:/index";
    }

}
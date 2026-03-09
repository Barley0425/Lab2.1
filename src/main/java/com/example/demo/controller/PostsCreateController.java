package com.example.demo.controller;

import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PostsCreateController {

    @Autowired
    private PostService postService;

    @GetMapping("/new")
    public String create() {
        return "create";
    }
    @PostMapping("/new")
    public String doCreate(@ModelAttribute("text") String text) {
        postService.create(text); // вызов метода сервиса для добавления поста
        return "redirect:/"; // редирект на главную страницу
    }
}

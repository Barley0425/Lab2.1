package com.example.demo.controller;

import com.example.demo.service.LikesService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/post")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/{id}/like")
    @ResponseBody
    public String like(@PathVariable("id") Long id) {
        try {
            int likes = likesService.like(id);
            return String.valueOf(likes);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }
}
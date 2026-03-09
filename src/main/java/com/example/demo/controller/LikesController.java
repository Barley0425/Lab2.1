
package com.example.demo.controller;

import com.example.demo.service.LikesService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/post/{id}/like")
    public String like(@PathVariable("id") Long id) {
        int likes = likesService.like(id);
        return String.valueOf(likes);
    }
}
package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();

    // Блок инициализации — заполняем начальные посты
    {
        posts.addAll(Arrays.asList(
                new Post(0L,"привет медвед", new Date()),
                new Post(1L, "магомед и гора", new Date()),
                new Post(2L, "тузик и грелка, я не знаю", new Date())
        ));
    }

    public List<Post> listAllPosts() {
        return posts;
    }

    public void create(String text) {
        Long newId = (long) posts.size(); // id = индексу в списке
        Post newPost = new Post(newId, text, new Date());
        posts.add(newPost);
    }
}
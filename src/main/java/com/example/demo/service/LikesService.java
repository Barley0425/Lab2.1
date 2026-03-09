package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class LikesService {

    @Autowired
    private PostService postService;

    public int like(Long postId) {
        List<Post> posts = postService.listAllPosts();

        // Проверка на существование поста
        if (postId < 0 || postId >= posts.size()) {
            throw new IllegalArgumentException("Post with id " + postId + " not found");
        }

        Post post = posts.get(postId.intValue());
        int newLikesCount = post.getLikes() + 1;
        post.setLikes(newLikesCount);
        return newLikesCount;
    }
}
package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class LikesService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public int like(Long postId) {
        System.out.println("Processing like for post ID: " + postId); // Логирование

        Optional<Post> postOpt = postRepository.findById(postId);

        if (postOpt.isEmpty()) {
            System.out.println("Post not found with ID: " + postId);
            throw new IllegalArgumentException("Post with id " + postId + " not found");
        }

        Post post = postOpt.get();
        System.out.println("Current likes: " + post.getLikes());

        int newLikesCount = post.getLikes() + 1;
        post.setLikes(newLikesCount);

        Post savedPost = postRepository.save(post);
        System.out.println("New likes count: " + savedPost.getLikes());

        return savedPost.getLikes();
    }
}
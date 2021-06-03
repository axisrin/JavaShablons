package com.example.practice14.controllers;

import com.example.practice14.models.Post;
import com.example.practice14.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping(value = "/getPosts", produces = "application/json")
    public List getPosts() {
        return postRepository.getPosts();
    }

    @GetMapping(value = "/addPost")
    public String addPost(@RequestParam String text,@RequestParam String creationDate) throws ParseException {
        postRepository.addPost(new Post(text,creationDate));
        return "ok";
    }

    @GetMapping(value = "/deletePost")
    public String deletePost(@RequestParam int index) {
        postRepository.removePost(index);
        return "ok";
    }

}

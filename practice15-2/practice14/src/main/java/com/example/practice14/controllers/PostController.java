package com.example.practice14.controllers;

import com.example.practice14.models.Post;
import com.example.practice14.repo.PostRepository;
import com.example.practice14.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {

//    PostRepository postRepository;
    @Autowired
    PostService postService;

    @GetMapping(value = "/getPosts", produces = "application/json")
    public List getPosts() {
        return postService.getAll();
    }

    @GetMapping(value = "/addPost")
    public String addPost(@RequestParam String text,@RequestParam String creationDate) throws ParseException {
        postService.save(text,creationDate);
        return "ok";
    }

    @GetMapping(value = "/deletePost")
    public String deletePost(@RequestParam int index) {
        postService.delete(index);
        return "ok";
    }

}

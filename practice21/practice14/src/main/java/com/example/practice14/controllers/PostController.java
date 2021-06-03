package com.example.practice14.controllers;

import com.example.practice14.models.Post;
import com.example.practice14.repo.PostRepository;
import com.example.practice14.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    public static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
//    PostRepository postRepository;
    @Autowired
    PostService postService;

    @GetMapping(value = "/getPosts", produces = "application/json")
    public List getPosts() {
        LOGGER.info("This is getPosts infoLog");
        return postService.getAll();
    }

//  1  http://localhost:8080/addPost?text=Hey bro, Hello!&creationDate=2020-05-20
//  2  http://localhost:8080/addPost?text=Misha privet , Hello!&creationDate=2021-01-12
    @GetMapping(value = "/addPost")
    public String addPost(@RequestParam String text,@RequestParam String creationDate,@RequestParam(required = false)
            Long postsUserId) throws ParseException {
        postService.save(text,creationDate, postsUserId);
        return "ok";
    }

// 1 http://localhost:8080/setUser?postId=3&postsUserId=1
// 2 http://localhost:8080/setUser?postId=4&postsUserId=2
    @GetMapping(value = "/setUser")
    public String setUser(@RequestParam Long postId, @RequestParam Long postsUserId) {
        postService.setUser(postId,postsUserId);
        return "ok";
    }

    @GetMapping(value = "/deletePost")
    public String deletePost(@RequestParam int index) {
        postService.delete(index);
        return "ok";
    }

}

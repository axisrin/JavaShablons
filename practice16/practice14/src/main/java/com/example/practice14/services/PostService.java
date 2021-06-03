package com.example.practice14.services;

import com.example.practice14.services.UserService;
import com.example.practice14.models.Post;
import com.example.practice14.models.User;
import com.example.practice14.repo.PostRepository;
import com.example.practice14.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public void save(String text,String creationDate, Long postsUserId) throws ParseException {
        postRepository.save(new Post(text,creationDate, postsUserId));
    }

    public User getUserByPost(Long postId) {
        return postRepository.getOne(postId).getUser();
    }

    public void setUser(Long postId,Long postsUserId) {
        postRepository.getOne(postId).setUser(userRepository.getOne(postsUserId));
    }

    public ArrayList<Post> getAll() {
        return new ArrayList<Post>(postRepository.findAll());
    }

    public void delete (long id) {
        postRepository.deleteById(id);
    }
}

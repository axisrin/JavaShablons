package com.example.practice14.services;

import com.example.practice14.models.Post;
import com.example.practice14.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public void save(String text,String creationDate) throws ParseException {
        postRepository.save(new Post(text,creationDate));
    }

    public ArrayList<Post> getAll() {
        return new ArrayList<Post>(postRepository.findAll());
    }

    public void delete (long id) {
        postRepository.deleteById(id);
    }
}

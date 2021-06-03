package com.example.practice14.repo;

import com.example.practice14.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    List<Post> posts;

    @Autowired
    public PostRepository() {
        posts = new ArrayList<Post>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void removePost(Post post) {
        posts.remove(post);
    }

    public void removePost(int index) {
        posts.remove(index);
    }

    public List<Post> getPosts() {
        return posts;
    }

}

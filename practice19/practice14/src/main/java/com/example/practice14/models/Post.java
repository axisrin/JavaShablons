package com.example.practice14.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Entity
@Table(name = "post", schema = "java_temp")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Long postsUserId;
    private String text = "null";
    private Date creationDate = null;

    public Post() {};

    public Post(String text, String creationDate) throws ParseException {
        this.text = text;
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        this.creationDate = parser.parse(creationDate);
    }

    public Post(String text, String creationDate, Long postsUserId) throws ParseException {
        this.postsUserId = postsUserId;
        this.text = text;
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        this.creationDate = parser.parse(creationDate);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        this.creationDate = parser.parse(creationDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPostsUserId() {
        return postsUserId;
    }

    public void setPostsUserId(Long postsUserId) {
        this.postsUserId = postsUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

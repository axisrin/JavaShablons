package com.example.practice14.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "posts")
@Component
public class Post {

    private String text = "null";
    @Column (name = "creation_date")
    private Date creationDate = null;
    private SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post() {};

    public Post(String text, String creationDate) throws ParseException {
        this.text = text;
        this.creationDate = parser.parse(creationDate);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) throws ParseException {
        this.creationDate = parser.parse(creationDate);
    }
}

package com.example.practice14.models;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Post {

    private String text = "null";
    private Date creationDate = null;
    private final SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

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

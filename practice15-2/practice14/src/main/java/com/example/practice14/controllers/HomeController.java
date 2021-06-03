package com.example.practice14.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String getHome() {
        return "Proshin Alexis IKBO-01-19 var-6";
    }
}

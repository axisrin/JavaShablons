package com.javapatsq.practice11.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private static final String appMessage = "Hi! You are in app! ";

    @RequestMapping("/")
    public String appGreeting(@RequestParam(value="appWord", required = false, defaultValue = "Stranger!")
                                          String appWord) {
        return appMessage + appWord;
    }
}

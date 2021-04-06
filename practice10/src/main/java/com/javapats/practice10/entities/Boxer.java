package com.javapats.practice10.entities;

import org.springframework.stereotype.Component;

@Component("bx")
public class Boxer implements Fighter{
    @Override
    public void doFight() {
        System.out.println("I'm a Boxer! KABOOM KABOOM!!");
    }
}

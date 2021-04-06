package com.javapats.practice10.entities;

import org.springframework.stereotype.Component;

@Component("jdka")
public class Judoka implements Fighter{
    @Override
    public void doFight() {
        System.out.println("I'm a Judoker! SKryaaaa Punch Leg!!");
    }
}

package com.javapats.practice10.entities;

import org.springframework.stereotype.Component;

@Component("sF")
public class StreetFighter implements Fighter{
    @Override
    public void doFight() {
        System.out.println("I'm a Street Fighter! KABOOM!");
    }
}

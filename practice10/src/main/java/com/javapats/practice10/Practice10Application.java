package com.javapats.practice10;

import com.javapats.practice10.entities.Boxer;
import com.javapats.practice10.entities.Fighter;
import com.javapats.practice10.entities.Judoka;
import com.javapats.practice10.entities.StreetFighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Practice10Application {

    public static void main(String[] args) {
//        SpringApplication.run(Practice10Application.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext("com.javapats.practice10.entities");

        Fighter fighter = context.getBean("sF",StreetFighter.class);
        fighter.doFight();

        fighter = context.getBean("bx", Boxer.class);
        fighter.doFight();

        fighter = context.getBean("jdka", Judoka.class);
        fighter.doFight();

    }

}

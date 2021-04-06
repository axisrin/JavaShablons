package com.javapats.practice12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.javapats.practice12.app.ConvertApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@SpringBootApplication
public class Practice12Application {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        ConvertApp.file1 = "/home/sumi-koon/HSE/Java Pats/practice12/src/main/java/com/javapats/practice12/sources/BeforeHash";
        ConvertApp.file2 = "/home/sumi-koon/HSE/Java Pats/practice12/src/main/java/com/javapats/practice12/sources/AfterHash.txt";

        SpringApplication.run(Practice12Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext("com/javapats/practice12/app");
//        ConvertApp convertApp = context.getBean(ConvertApp.class);

//        ConvertApp convertApp = new ConvertApp();
//        convertApp.init();
//        convertApp.deleteOriginFile();


    }

}

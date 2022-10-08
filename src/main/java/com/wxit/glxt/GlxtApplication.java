package com.wxit.glxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlxtApplication.class, args);

//        try {
//            Runtime.getRuntime().exec("cmd /c start http://localhost:8080/");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}

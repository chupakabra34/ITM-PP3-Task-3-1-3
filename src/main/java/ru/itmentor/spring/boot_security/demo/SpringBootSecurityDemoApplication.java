package ru.itmentor.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
//        try {
//            Runtime.getRuntime().exec("cmd /c start http://localhost:8080/login");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    }
}
package com.rezed;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    record Person(String name, int age) {}
    record Message(String message, List<String> favLanguages, Person person) {}

    public static void main(String[] args) {
        System.out.println(Main.class);
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public Message getHello() {
        return new Message(
            "Hello, World!",
            List.of("Java", "Python", "Golang"),
            new Person("Rezed", 20)
        );
    }
}

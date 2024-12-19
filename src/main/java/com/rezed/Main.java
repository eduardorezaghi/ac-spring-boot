package com.rezed;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Message getHello(
        @RequestParam(value = "name", required = false, defaultValue = "World") String name,
        @RequestParam(value = "age", required = false, defaultValue = "20") int age
    ) {
        return new Message(
            String.format("Hello, %s!", name == null || name.isBlank() ? "World" : name),
            List.of("Java", "Python", "Golang"),
            new Person(name, age)
        );
    }

    @GetMapping("/sim-error")
    public ResponseEntity<String> getErrorSim() {
        return ResponseEntity.status(500).body("Error");
    }
}

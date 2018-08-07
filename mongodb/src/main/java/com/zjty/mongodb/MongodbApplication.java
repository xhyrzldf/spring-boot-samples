package com.zjty.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@SpringBootApplication
@RestController
@RequestMapping("/users")
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NextSequenceService nss;

    @PostMapping
    public ResponseEntity insertUser(@RequestBody User user) {
        user.setId(nss.getNextSequence("users"));
        return ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity findUsers() {
        return ok(userRepository.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity findByName(@PathVariable("name") String name) {
        return ok(userRepository.findByUsername(name));
    }
}

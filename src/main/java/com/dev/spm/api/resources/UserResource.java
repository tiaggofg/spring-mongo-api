package com.dev.spm.api.resources;

import com.dev.spm.api.domain.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User alex = new User("1", "Alex Green", "alex.green@mail.com");
        User maria = new User("2", "Maria Brown", "maria.brown@mail.com");
        List<User>  users = new ArrayList<>();
        users.addAll(Arrays.asList(alex, maria));
        return ResponseEntity.ok().body(users);
    }

}

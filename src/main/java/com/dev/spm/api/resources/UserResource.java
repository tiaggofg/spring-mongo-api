package com.dev.spm.api.resources;

import com.dev.spm.api.domain.User;
import com.dev.spm.api.dtos.UserDto;
import com.dev.spm.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = userService.findAll().stream().map(u -> new UserDto(u)).collect(Collectors.toList());
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

}

package com.dev.spm.api.services;

import com.dev.spm.api.domain.User;
import com.dev.spm.api.repository.UserRepository;
import com.dev.spm.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário id: " + id + " não encontrado!"));
    }

}

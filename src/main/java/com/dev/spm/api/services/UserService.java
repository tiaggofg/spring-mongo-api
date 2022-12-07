package com.dev.spm.api.services;

import com.dev.spm.api.domain.User;
import com.dev.spm.api.dtos.UserDto;
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

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        update(newUser, user);
        return userRepository.save(newUser);
    }

    private void update(User newUser, User user) {
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
    }
}

package com.dev.spm.api.config;

import com.dev.spm.api.domain.Post;
import com.dev.spm.api.domain.User;
import com.dev.spm.api.dtos.AuthorDto;
import com.dev.spm.api.repositories.PostRepository;
import com.dev.spm.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, sdf.parse("21/11/2022"), "Partiu viajar", "Vou viajar para São Paulo, abraços!", new AuthorDto(maria));
        Post p2 = new Post(null, sdf.parse("31/11/2022"), "Bom dia", "Acordei feliz hoje", new AuthorDto(alex));

        maria.getPosts().add(p1);
        alex.getPosts().add(p2);

        postRepository.saveAll(Arrays.asList(p1, p2));
        userRepository.saveAll(Arrays.asList(maria, alex));
    }
}

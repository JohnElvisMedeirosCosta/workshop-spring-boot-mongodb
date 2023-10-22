package com.john.workshopmongo.config;

import com.john.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.john.workshopmongo.repository.UserRepository;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll(); // Para limpar a coleção no MongoDB

        User maria = new User(null, "Maria Brown", "maria@mail.com");
        User alex = new User(null, "Alex Green", "alex@mail.com");
        User bob = new User(null, "Bob Grey", "bob@mail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}

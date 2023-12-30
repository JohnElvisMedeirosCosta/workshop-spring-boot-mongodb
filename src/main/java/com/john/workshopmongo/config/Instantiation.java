package com.john.workshopmongo.config;

import com.john.workshopmongo.domain.User;
import com.john.workshopmongo.domain.Post;
import com.john.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.john.workshopmongo.repository.UserRepository;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll(); // Para limpar a coleção no MongoDB
        postRepository.deleteAll(); // Para limpar a coleção no MongoDB

        User maria = new User(null, "Maria Brown", "maria@mail.com");
        User alex = new User(null, "Alex Green", "alex@mail.com");
        User bob = new User(null, "Bob Grey", "bob@mail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);


        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}

package com.project.apispringtest.config;

import com.project.apispringtest.domain.Post;
import com.project.apispringtest.domain.User;
import com.project.apispringtest.dto.AuthorDTO;
import com.project.apispringtest.dto.CommentDTO;
import com.project.apispringtest.repositories.PostRepositories;
import com.project.apispringtest.repositories.UserRepositories;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{
    
    @Autowired
    private UserRepositories userRepositories;
    
    @Autowired
    private PostRepositories postRepositories;
        
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat dataformat = new SimpleDateFormat("dd/MM/yyyy");
        dataformat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepositories.deleteAll();
        postRepositories.deleteAll();

        User maria = new User(null, "Maria", "maria@gmail.com");
        User alex = new User(null, "Alex", "alex@gmail.com");
        User bobby = new User(null, "Bobby", "bob@gmail.com");

        userRepositories.saveAll(Arrays.asList(maria, alex, bobby));

        Post post1 = new Post(null, dataformat.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, dataformat.parse("23/03/2018"), "Bom dia", "Acordei muito feliz!", new AuthorDTO(maria));
        Post post3 = new Post(null, dataformat.parse("23/03/2018"), "Bom dia", "Acordei muito feliz!", new AuthorDTO(bobby));
        
        CommentDTO c1 = new CommentDTO("Boa viagem mano!", dataformat.parse("22/07/2021"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", dataformat.parse("22/07/2021"), new AuthorDTO(bobby));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", dataformat.parse("22/07/2021"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepositories.saveAll(Arrays.asList(post1, post2, post3));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        bobby.getPosts().addAll(Arrays.asList(post3));
        
        userRepositories.save(maria);
        userRepositories.save(bobby);

    }

}
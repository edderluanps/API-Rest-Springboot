package com.project.apispringtest.config;

import com.project.apispringtest.domain.Post;
import com.project.apispringtest.domain.User;
import com.project.apispringtest.dto.AuthorDTO;
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
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        userRepositories.deleteAll();
        postRepositories.deleteAll();
    
        User maria = new User(null, "Maria Brown", "mary@email.com");
        User alex = new User(null, "Alex Green", "alex@email.com");
        User bobby = new User(null, "Bobby Grey", "bobby@email.com");
        
        userRepositories.saveAll(Arrays.asList(maria, alex, bobby));
        
        Post post1 = new Post(null, sdf.parse("21/03/2021"), "Partiu viagem", "Vou viajar para sp, partiu viagem!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("21/03/2021"), "Partiu viagem", "Cheguei em sp!", new AuthorDTO(maria));
        Post post3 = new Post(null, sdf.parse("21/03/2021"), "Bom dia", "Bom dia!!", new AuthorDTO(alex));
        
        postRepositories.saveAll(Arrays.asList(post1, post2, post3));
        
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        alex.getPosts().addAll(Arrays.asList(post3));
        userRepositories.save(maria);
        userRepositories.save(alex);
    }
    
}

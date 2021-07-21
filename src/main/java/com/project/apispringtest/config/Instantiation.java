package com.project.apispringtest.config;

import com.project.apispringtest.domain.User;
import com.project.apispringtest.repositories.UserRepositories;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{
    
    @Autowired
    private UserRepositories userRepositories;
    
    @Override
    public void run(String... args) throws Exception {
        
        userRepositories.deleteAll();
    
        User maria = new User(null, "Maria Brown", "mary@email.com");
        User alex = new User(null, "Alex Green", "alex@email.com");
        User bobby = new User(null, "Bobby Grey", "bobby@email.com");
        
        userRepositories.saveAll(Arrays.asList(maria, alex, bobby));
        
    }
    
}

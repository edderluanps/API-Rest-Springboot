package com.project.apispringtest.services;

import com.project.apispringtest.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.apispringtest.repositories.UserRepositories;
import org.springframework.stereotype.Component;

@Service
@Component
public class UserServices {
    
    @Autowired
    private UserRepositories urepo;

    public List<User> findAll(){
        
        return urepo.findAll();
        
    }
    
}

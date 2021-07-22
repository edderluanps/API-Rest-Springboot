package com.project.apispringtest.services;

import com.project.apispringtest.domain.User;
import com.project.apispringtest.dto.UserDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apispringtest.repositories.UserRepositories;
import com.project.apispringtest.services.exception.ObjectNotFoundException;
import java.util.Optional;

@Service
public class UserServices {
    
    @Autowired
    private UserRepositories urepo;

    public List<User> findAll(){
        
        return urepo.findAll();
        
    }

    public User findById(String id) {
        
        Optional<User> obj = urepo.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        
        return urepo.insert(obj);
    }
    
    public User fromDTO(UserDTO objdto){
        return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
    }

}

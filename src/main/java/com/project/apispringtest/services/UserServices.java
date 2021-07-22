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
    private UserRepositories repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }
    
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}

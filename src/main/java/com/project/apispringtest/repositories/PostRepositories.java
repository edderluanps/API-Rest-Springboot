package com.project.apispringtest.repositories;

import com.project.apispringtest.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public interface PostRepositories extends MongoRepository<Post, String>{
    
}

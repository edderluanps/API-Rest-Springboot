package com.project.apispringtest.services;

import com.project.apispringtest.domain.Post;
import com.project.apispringtest.repositories.PostRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apispringtest.services.exception.ObjectNotFoundException;
import java.util.Date;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostRepositories repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }

}

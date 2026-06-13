package io.github.joseGuilhermeG.libraryapi.services;

import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author save(Author author){
        return repository.save(author);
    }

    public Author detail(UUID id){
        return  repository.findById(id).orElse(null);
    }

    public boolean delete(UUID id){
        boolean authorExists = repository.existsById(id);
        if(! authorExists) return false;
        repository.deleteById(id);
        return true;
    }

    public List<Author> search(String name , String nationality){
        if(name != null && nationality != null) return repository.findByNameAndNationality(name , nationality);
        if(name != null) return repository.findByName(name);
        if(nationality != null) return repository.findByNationality(nationality);
        return repository.findAll();
    }

    public boolean update(UUID id , Author author){
        Boolean authorExists = repository.existsById(id);
        if(!authorExists) return false;
        author.setId(id);
        repository.save(author);
        return true;
    }
}

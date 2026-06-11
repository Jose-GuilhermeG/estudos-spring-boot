package io.github.joseGuilhermeG.libraryapi.services;

import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

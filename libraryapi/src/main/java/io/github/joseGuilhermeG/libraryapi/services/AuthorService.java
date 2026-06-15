package io.github.joseGuilhermeG.libraryapi.services;

import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import io.github.joseGuilhermeG.libraryapi.validator.AuthorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;
    private final AuthorValidator validator;

    public Author save(Author author){
        validator.validate(author);
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
        Author author = new Author();
        author.setName(name);
        author.setNationality(nationality);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Author> authorExample = Example.of(author,matcher);

        return repository.findAll(authorExample);
    }

    public boolean update(UUID id , Author author){
        Boolean authorExists = repository.existsById(id);
        if(!authorExists) return false;
        author.setId(id);
        repository.save(author);
        return true;
    }
}

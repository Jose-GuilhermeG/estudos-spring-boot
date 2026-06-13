package io.github.joseGuilhermeG.libraryapi.validator;

import io.github.joseGuilhermeG.libraryapi.exceptions.AlreadyExistsException;
import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthorValidator {
    private AuthorRepository repository;

    public AuthorValidator(AuthorRepository repository) {
        this.repository = repository;
    }

    public void validate(Author author){
        if (authorAlrightExists(author)) throw new AlreadyExistsException("That author Already exists");
    }

    private boolean authorAlrightExists(Author author){
        return repository.existsByNameAndBornDateAndNationality(author.getName(),author.getBornDate(),author.getNationality());
    }
}

package io.github.joseGuilhermeG.libraryapi.controllers;

import io.github.joseGuilhermeG.libraryapi.dto.CreateAuthorDTO;
import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import io.github.joseGuilhermeG.libraryapi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("authors/")
public class AuthorControllers {

    @Autowired
    private AuthorService service;

    @PostMapping
    ResponseEntity<Void> createAuthor(@RequestBody CreateAuthorDTO data){
        Author instance = service.save(data.toAuthor());
        URI instanceDetail = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(instance.getId())
                .toUri();
        return ResponseEntity.created(instanceDetail).build();
    }
}

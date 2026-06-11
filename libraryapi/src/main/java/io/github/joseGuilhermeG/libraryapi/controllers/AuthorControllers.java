package io.github.joseGuilhermeG.libraryapi.controllers;

import io.github.joseGuilhermeG.libraryapi.dto.AuthorDetailDTO;
import io.github.joseGuilhermeG.libraryapi.dto.CreateAuthorDTO;
import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import io.github.joseGuilhermeG.libraryapi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("{id}")
    ResponseEntity<AuthorDetailDTO> detailAuthor(@PathVariable String id){
        Author author = service.detail(UUID.fromString(id));
        if(author == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new AuthorDetailDTO(author.getId() , author.getName() , author.getBornDate() , author.getNationality()));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteAuthor(@PathVariable String id){
        boolean isDeleted = service.delete(UUID.fromString(id));
        if(!isDeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}

package io.github.joseGuilhermeG.libraryapi.controllers;

import io.github.joseGuilhermeG.libraryapi.dto.AuthorDetailDTO;
import io.github.joseGuilhermeG.libraryapi.dto.CreateAuthorDTO;
import io.github.joseGuilhermeG.libraryapi.dto.Erros.ErroResponse;
import io.github.joseGuilhermeG.libraryapi.exceptions.AlreadyExistsException;
import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("authors/")
public class AuthorControllers {

    @Autowired
    private AuthorService service;

    @PostMapping
    ResponseEntity<Object> createAuthor(@RequestBody CreateAuthorDTO data){
        try{
            Author instance = service.save(data.toAuthor());
            URI instanceDetail = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(instance.getId())
                    .toUri();
            return ResponseEntity.created(instanceDetail).build();
        }catch (AlreadyExistsException e){
            ErroResponse err = ErroResponse.conflit(e.getMessage());
            return ResponseEntity.status(err.Status()).body(err);
        }
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

    @GetMapping
    ResponseEntity<List<AuthorDetailDTO>> search(@RequestParam(required = false) String name , @RequestParam(required = false) String nationality){
        List<AuthorDetailDTO> response = new ArrayList<AuthorDetailDTO>();
        List<Author> query = service.search(name , nationality);
        query.forEach(element -> response.add(new AuthorDetailDTO(element.getId() , element.getName() ,element.getBornDate() ,element.getNationality())));
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    ResponseEntity<Void> update(@PathVariable String id ,@RequestBody  CreateAuthorDTO data){
        Boolean authorIsUpdated = service.update(UUID.fromString(id) , data.toAuthor());
        if(!authorIsUpdated) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}

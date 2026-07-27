package io.github.joseGuilhermeG.libraryapi.controllers;

import io.github.joseGuilhermeG.libraryapi.dto.users.CreateUserDTO;
import io.github.joseGuilhermeG.libraryapi.mappers.UserMapper;
import io.github.joseGuilhermeG.libraryapi.models.User;
import io.github.joseGuilhermeG.libraryapi.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserMapper mapper;
    private final UserService service;

    @PostMapping("/register/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createUser(@RequestBody @Valid CreateUserDTO data){
        service.createUser(mapper.toEntity(data));
        return  ResponseEntity.ok().build();
    }

}

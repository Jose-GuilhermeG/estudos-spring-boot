package io.github.joseGuilhermeG.libraryapi.controllers;

import io.github.joseGuilhermeG.libraryapi.dto.Erros.ErroResponse;
import io.github.joseGuilhermeG.libraryapi.dto.books.RegisterBookDTO;
import io.github.joseGuilhermeG.libraryapi.exceptions.AlreadyExistsException;
import io.github.joseGuilhermeG.libraryapi.mappers.BookMapper;
import io.github.joseGuilhermeG.libraryapi.models.Book;
import io.github.joseGuilhermeG.libraryapi.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookControllers {

    private final BookService service;
    private final BookMapper mapper;

    @PostMapping
    public ResponseEntity<Object> createBook(@RequestBody @Valid RegisterBookDTO data){
        try{
            Book book = service.registerBook(mapper.toEntity(data) , data.authorId());
            return ResponseEntity.ok(book);
        }catch (AlreadyExistsException e) {
            ErroResponse erroResponse = ErroResponse.conflit(e.getMessage());
            return  ResponseEntity.status(erroResponse.Status()).body(erroResponse.message());
        }
    }

}

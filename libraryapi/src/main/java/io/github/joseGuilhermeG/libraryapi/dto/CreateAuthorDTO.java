package io.github.joseGuilhermeG.libraryapi.dto;

import io.github.joseGuilhermeG.libraryapi.models.Author;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateAuthorDTO(
        @NotBlank(message = "Name can't be blank")
        @Size(message = "Name size can't be grater them 100" , max = 100 , min = 2)
        String name ,
        @NotNull(message = "field required")
        @Future
        LocalDate bornDate,
        @Size(message = "nationality size can't be grater them 40" , max = 40 , min = 2)
        @NotBlank(message = "field required")
        String nationality
){

    public Author toAuthor(){
        Author author = new Author();
        author.setName(name);
        author.setBornDate(bornDate);
        author.setNationality(nationality);

        return  author;
    }
}

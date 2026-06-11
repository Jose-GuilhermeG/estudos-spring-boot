package io.github.joseGuilhermeG.libraryapi.dto;

import io.github.joseGuilhermeG.libraryapi.models.Author;

import java.time.LocalDate;

public record CreateAuthorDTO(String name , LocalDate bornDate , String nationality){

    public Author toAuthor(){
        Author author = new Author();
        author.setName(name);
        author.setBorn_date(bornDate);
        author.setNationality(nationality);

        return  author;
    }
}

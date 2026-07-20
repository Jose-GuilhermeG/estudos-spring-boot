package io.github.joseGuilhermeG.libraryapi.dto.books;

import io.github.joseGuilhermeG.libraryapi.dto.AuthorDetailDTO;
import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.models.Enums.BookType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SearchBookDTO(
        String isbn,
        String title,
        LocalDate publishDate,
        BookType type,
        BigDecimal price,
        AuthorDetailDTO author
){}

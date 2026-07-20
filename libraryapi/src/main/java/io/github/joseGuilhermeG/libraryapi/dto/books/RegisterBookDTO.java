package io.github.joseGuilhermeG.libraryapi.dto.books;

import io.github.joseGuilhermeG.libraryapi.models.Book;
import io.github.joseGuilhermeG.libraryapi.models.Enums.BookType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record RegisterBookDTO(
        @ISBN
        @NotBlank(message = "isbn can't be blank")
        String isbn,
        @NotBlank(message = "title can't be blank")
        String title,
        @NotNull
        @Past
        LocalDate publishDate,

        BookType type,
        BigDecimal price,
        @NotNull
        UUID authorId

){

    public Book toBook(){
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setPublish_date(publishDate);
        book.setType(type);
        book.setPrice(price);
        return book;
    }

}

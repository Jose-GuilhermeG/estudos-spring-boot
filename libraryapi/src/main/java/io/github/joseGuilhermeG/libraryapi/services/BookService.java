package io.github.joseGuilhermeG.libraryapi.services;

import io.github.joseGuilhermeG.libraryapi.exceptions.AlreadyExistsException;
import io.github.joseGuilhermeG.libraryapi.exceptions.NotFoundException;
import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.models.Book;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import io.github.joseGuilhermeG.libraryapi.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public Book registerBook(Book book , UUID authorId){
        isbnAlreadyExists(book.getIsbn());
        book.setAuthor(getAuthorOrFail(authorId));
        return repository.save(book);
    }

    private Author getAuthorOrFail(UUID authorId){
        return authorRepository.findById(authorId).orElseThrow(()->new NotFoundException(String.format("There are not any author with id : %s",authorId.toString())));
    }

    private void isbnAlreadyExists(String isbn){
        if(repository.existsByIsbn(isbn)) throw new AlreadyExistsException(String.format("a book with the isbn '%s' already exists",isbn));
    }

}

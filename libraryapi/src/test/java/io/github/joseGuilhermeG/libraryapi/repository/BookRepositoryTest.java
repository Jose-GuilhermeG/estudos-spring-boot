package io.github.joseGuilhermeG.libraryapi.repository;

import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.models.Book;
import io.github.joseGuilhermeG.libraryapi.models.Enums.BookType;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import io.github.joseGuilhermeG.libraryapi.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;

@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;

    private Author authorTest;


    @BeforeEach
    void createAuthor(){
        authorTest = authorRepository.save(getTestAuthor());
    }

    private Author getTestAuthor(){
        Author author = new Author();
        author.setName("test");
        author.setNationality("brasileiro");
        author.setBorn_date(LocalDate.of(1951,1,20));
        return author;
    }

    @Test
    void createBookTest(){
        Book book = new Book();
        book.setIsbn("90887-84874");
        book.setTitle("Metamorfose");
        book.setPrice(BigDecimal.valueOf(38.90));
        book.setType(BookType.FICCAO);
        book.setPublish_date(LocalDate.of(1990,01,11));
        book.setAuthor(authorTest);

        book = repository.save(book);
        System.out.println("Livro crido:" + book);
    }


}

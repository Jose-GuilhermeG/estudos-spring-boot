package io.github.joseGuilhermeG.libraryapi.repository;

import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ActiveProfiles("test")
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;
    private Author testAuthor;

    @BeforeEach
     void setUp(){
        this.testAuthor = repository.save(getTestAuthor());
    }

    private static Author getTestAuthor(){
        Author author = new Author();
        author.setName("test");
        author.setNationality("brasileiro");
        author.setBorn_date(LocalDate.of(1951,1,20));
        return author;
    }

    @Test
    public void testCreate(){
        Author author = new Author();
        author.setName("maria");
        author.setNationality("brasileiro");
        author.setBorn_date(LocalDate.of(1951,1,20));
        author = repository.save(author);
        System.out.println("Author salvo: " + author);
    }

    @Test
    public void testUpdate(){
        Author authorUpdated = testAuthor;
        authorUpdated.setName("Guilherme");
        authorUpdated = repository.save(authorUpdated);
        System.out.println("Author atualizado: " + authorUpdated);
    }

    @Test
    public void testList(){
        List<Author> authorList = repository.findAll();
        authorList.forEach(System.out::println);
    }

    @Test
    public void testCount(){
        System.out.println("Quantidade de autores: " + repository.count());
    }

    @Test
    public void deleteTest(){
        UUID authorId = testAuthor.getId();
        repository.deleteById(authorId);
        System.out.println("User deletado :" + !repository.existsById(authorId));
    }

}

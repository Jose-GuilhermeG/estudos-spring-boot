package io.github.joseGuilhermeG.libraryapi;

import io.github.joseGuilhermeG.libraryapi.models.Author;
import io.github.joseGuilhermeG.libraryapi.models.Book;
import io.github.joseGuilhermeG.libraryapi.repositories.AuthorRepository;
import io.github.joseGuilhermeG.libraryapi.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        AuthorRepository repository = context.getBean(AuthorRepository.class);
        createAuthorExample(repository);
	}

    public static void createAuthorExample(AuthorRepository repository){
        Author author = new Author();
        author.setName("José");
        author.setNationality("brasileiro");
        author.setBorn_date(LocalDate.of(1950,1,20));

        author = repository.save(author);
        System.out.println("Author salvo: " + author);

    }
}

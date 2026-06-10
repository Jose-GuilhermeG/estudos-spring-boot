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

        SpringApplication.run(Application.class, args);
	}
}

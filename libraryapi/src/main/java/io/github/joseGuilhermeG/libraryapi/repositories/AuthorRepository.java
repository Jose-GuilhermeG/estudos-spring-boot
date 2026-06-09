package io.github.joseGuilhermeG.libraryapi.repositories;

import io.github.joseGuilhermeG.libraryapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author , UUID> {
}

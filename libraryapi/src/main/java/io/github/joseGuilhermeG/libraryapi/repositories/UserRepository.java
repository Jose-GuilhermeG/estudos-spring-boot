package io.github.joseGuilhermeG.libraryapi.repositories;

import io.github.joseGuilhermeG.libraryapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User , UUID> {
    public boolean existsByUsername(String username);
}

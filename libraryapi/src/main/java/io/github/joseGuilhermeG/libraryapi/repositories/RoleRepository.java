package io.github.joseGuilhermeG.libraryapi.repositories;

import io.github.joseGuilhermeG.libraryapi.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles , Integer> {

}

package io.github.joseGuilhermeG.libraryapi.dto;

import java.time.LocalDate;
import java.util.UUID;

public record AuthorDetailDTO(UUID id , String name , LocalDate bornDate , String nationality) {
}

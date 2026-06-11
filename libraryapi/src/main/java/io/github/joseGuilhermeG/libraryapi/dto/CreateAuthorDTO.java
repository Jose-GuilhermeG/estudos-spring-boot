package io.github.joseGuilhermeG.libraryapi.dto;

import java.time.LocalDate;

public record CreateAuthorDTO(String name , LocalDate bornDate , String nationality){}

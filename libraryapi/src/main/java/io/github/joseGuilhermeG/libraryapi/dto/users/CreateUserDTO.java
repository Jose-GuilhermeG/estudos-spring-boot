package io.github.joseGuilhermeG.libraryapi.dto.users;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
        @NotBlank(message = "username can't be blank")
        String username,
        @NotBlank(message = "password can't be blank")
        String password
) {
}

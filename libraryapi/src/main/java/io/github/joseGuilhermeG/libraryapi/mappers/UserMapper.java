package io.github.joseGuilhermeG.libraryapi.mappers;

import io.github.joseGuilhermeG.libraryapi.dto.users.CreateUserDTO;
import io.github.joseGuilhermeG.libraryapi.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    public User toEntity(CreateUserDTO dto);

}

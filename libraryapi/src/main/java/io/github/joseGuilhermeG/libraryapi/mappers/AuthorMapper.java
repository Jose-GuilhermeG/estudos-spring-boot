package io.github.joseGuilhermeG.libraryapi.mappers;

import io.github.joseGuilhermeG.libraryapi.dto.AuthorDetailDTO;
import io.github.joseGuilhermeG.libraryapi.dto.CreateAuthorDTO;
import io.github.joseGuilhermeG.libraryapi.models.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper {
    Author toEntity(AuthorDetailDTO dto);
    Author toEntity(CreateAuthorDTO dto);
    AuthorDetailDTO toDTO(Author entity);
}

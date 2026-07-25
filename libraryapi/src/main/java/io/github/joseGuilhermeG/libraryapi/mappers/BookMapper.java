package io.github.joseGuilhermeG.libraryapi.mappers;

import io.github.joseGuilhermeG.libraryapi.dto.books.RegisterBookDTO;
import io.github.joseGuilhermeG.libraryapi.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    Book toEntity(RegisterBookDTO dto);
}

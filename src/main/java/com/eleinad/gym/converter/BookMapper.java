package com.eleinad.gym.converter;

import com.eleinad.gym.entity.Book;
import com.eleinad.gym.model.BookDTO;
import org.mapstruct.*;

@Named("BookMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {AuthorMapper.class})
public interface BookMapper {

    @Named("toDTO")
    @Mappings({
            @Mapping(source = "authors", target = "authorDTOs", qualifiedByName = {"AuthorMapper", "toDtoWithoutBook"}),
            @Mapping(target = "authorsID", ignore = true)})
    BookDTO toDTO(Book book);

    @Named("toDtoWithoutAuthor")
    @Mappings({
            @Mapping(target = "authorDTOs", ignore = true, expression = "java(null)"),
            @Mapping(target = "authorsID", ignore = true)})
    BookDTO toDtoWithoutAuthor(Book book);

    @Named("toDto")
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "authors", ignore = true),
    })
    Book fromDTO(BookDTO bookDTO);
}

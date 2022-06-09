package com.eleinad.gym.converter;

import com.eleinad.gym.entity.Author;
import com.eleinad.gym.model.AuthorDTO;
import org.mapstruct.*;

@Named("AuthorMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {BookMapper.class})
public interface AuthorMapper {

    @Named("toDto")
    @Mappings({
            @Mapping(source = "books", target = "bookDTOs", qualifiedByName = {"BookMapper", "toDtoWithoutAuthor"})})
    AuthorDTO toDto(Author author);

    @Named("toDtoWithoutBook")
    @Mappings({
            @Mapping(target = "bookDTOs", expression = "java(null)")})
    AuthorDTO toDtoWithoutBook(Author author);

}

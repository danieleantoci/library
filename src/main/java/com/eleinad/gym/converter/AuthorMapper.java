package com.eleinad.gym.converter;

import com.eleinad.gym.entity.AuthorDTO;
import com.eleinad.gym.model.Author;
import org.mapstruct.*;

@Named("AuthorMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {BookMapper.class})
public interface AuthorMapper {

    @Named("fromDto")
    @Mappings({
            @Mapping(target = "books", qualifiedByName = {"BookMapper", "fromDtoWithoutAuthor"})})
    Author fromDTO(AuthorDTO authorDTO);

    @Named("fromDtoWithoutBook")
    @Mappings({
            @Mapping(target = "books", expression = "java(null)")})
    Author fromDtoWithoutBook(AuthorDTO authorDTO);

}

package com.eleinad.gym.converter;

import com.eleinad.gym.entity.BookDTO;
import com.eleinad.gym.model.Book;
import org.mapstruct.*;

@Named("BookMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {AuthorMapper.class})
public interface BookMapper {

    @Named("fromDto")
    @Mappings({
            @Mapping(target = "authors", qualifiedByName = {"AuthorMapper", "fromDtoWithoutBook"})})
    Book fromDto(BookDTO bookDTO);

    @Named("fromDtoWithoutAuthor")
    @Mappings({
            @Mapping(target = "authors", expression = "java(null)")})
    Book fromDtoWithoutAuthor(BookDTO bookDTO);

    @Named("toDto")
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "authors", ignore = true),
    })
    BookDTO toDto(Book book);
}

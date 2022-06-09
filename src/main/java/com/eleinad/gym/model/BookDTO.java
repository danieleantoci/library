package com.eleinad.gym.model;

import com.eleinad.gym.types.Language;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BookDTO {

    private Long id;
    private String asin;
    private String title;
    private boolean isEbook;
    private Language language;
    @JsonProperty(value = "authors")
    private List<AuthorDTO> authorDTOs;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String authorsID;

}

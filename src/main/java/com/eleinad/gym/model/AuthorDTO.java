package com.eleinad.gym.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDTO {

    private Long id;
    private String name;
    @JsonProperty(value = "books")
    private List<BookDTO> bookDTOs;

}

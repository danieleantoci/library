package com.eleinad.gym.model;

import com.eleinad.gym.types.Language;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Book {

    private Long id;
    private String asin;
    private String title;
    private boolean isEbook;
    private Language language;
    private List<Author> authors;
    private String authorsID;

}

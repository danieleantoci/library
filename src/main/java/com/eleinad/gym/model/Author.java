package com.eleinad.gym.model;

import lombok.Data;

import java.util.List;

@Data
public class Author {

    private Long id;
    private String name;
    private List<Book> books;

}

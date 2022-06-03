package com.eleinad.gym.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity(name = "AUTHOR")
public class AuthorDTO {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", insertable = false, updatable = false, nullable = false)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BookDTO> books;
}

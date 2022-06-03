package com.eleinad.gym.entity;

import com.eleinad.gym.types.Language;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity(name = "BOOK")
public class BookDTO {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", insertable = false, updatable = false, nullable = false)
    private Long id;
    @NotNull
    private String asin;
    @NotNull
    private String title;
    @NotNull
    private boolean isEbook;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Language language;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    @NotNull
    private List<AuthorDTO> authors;
}

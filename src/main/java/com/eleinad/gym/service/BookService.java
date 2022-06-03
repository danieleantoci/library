package com.eleinad.gym.service;

import com.eleinad.gym.converter.BookMapper;
import com.eleinad.gym.model.Book;
import com.eleinad.gym.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepo;
    private final BookMapper mapper;

    @Autowired
    public BookService(BookRepository bookRepo, BookMapper mapper) {
        this.bookRepo = bookRepo;
        this.mapper = mapper;
    }

    public List<Book> findAll() {
        return bookRepo
                .findAll()
                .stream()
                .map(mapper::fromDto)
                .collect(Collectors.toList());
    }

}

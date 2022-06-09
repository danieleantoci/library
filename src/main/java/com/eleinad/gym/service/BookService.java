package com.eleinad.gym.service;

import com.eleinad.gym.converter.BookMapper;
import com.eleinad.gym.entity.Author;
import com.eleinad.gym.entity.Book;
import com.eleinad.gym.model.BookDTO;
import com.eleinad.gym.repo.AuthorRepository;
import com.eleinad.gym.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final BookMapper mapper;

    @Autowired
    public BookService(BookRepository bookRepo, AuthorRepository authorRepo, BookMapper mapper) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.mapper = mapper;
    }

    public List<BookDTO> findAll() {
        return bookRepo
                .findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public void createBook(BookDTO bookDTO) {
        final Book book = mapper.fromDTO(bookDTO);
        List<Author> authors = Arrays
                .stream(bookDTO.getAuthorsID().split(","))
                .map(s -> authorRepo.findById(Long.parseLong(s)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .peek(authorDTO -> authorDTO.addBook(book))
                .collect(Collectors.toList());
        book.setAuthors(authors);
        bookRepo.save(book);
    }
}

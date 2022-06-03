package com.eleinad.gym.service;

import com.eleinad.gym.converter.BookMapper;
import com.eleinad.gym.entity.AuthorDTO;
import com.eleinad.gym.entity.BookDTO;
import com.eleinad.gym.model.Book;
import com.eleinad.gym.repo.AuthorRepository;
import com.eleinad.gym.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<Book> findAll() {
        return bookRepo
                .findAll()
                .stream()
                .map(mapper::fromDto)
                .collect(Collectors.toList());
    }

    public void createBook(Book book) {
        final BookDTO bookDTO = mapper.toDto(book);
        List<AuthorDTO> authors = Arrays
                .stream(book.getAuthorsID().split(","))
                .map(s -> authorRepo.findById(Long.parseLong(s)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .peek(authorDTO -> authorDTO.addBook(bookDTO))
                .collect(Collectors.toList());
        bookDTO.setAuthors(authors);
        bookRepo.save(bookDTO);
    }
}

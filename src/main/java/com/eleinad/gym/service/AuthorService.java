package com.eleinad.gym.service;

import com.eleinad.gym.converter.AuthorMapper;
import com.eleinad.gym.entity.Author;
import com.eleinad.gym.model.AuthorDTO;
import com.eleinad.gym.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {


    private final AuthorRepository authorRepo;
    private final AuthorMapper mapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepo, AuthorMapper mapper) {
        this.authorRepo = authorRepo;
        this.mapper = mapper;
    }


    public List<AuthorDTO> findAll() {
        final List<Author> authors = authorRepo.findAll();
        return authors
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}

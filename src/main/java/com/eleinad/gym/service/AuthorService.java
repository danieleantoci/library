package com.eleinad.gym.service;

import com.eleinad.gym.converter.AuthorMapper;
import com.eleinad.gym.entity.AuthorDTO;
import com.eleinad.gym.model.Author;
import com.eleinad.gym.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private AuthorMapper mapper;

    public List<Author> findAll() {
        final List<AuthorDTO> authorDTOs = authorRepo.findAll();
        return authorDTOs
                .stream()
                .map(mapper::fromDTO)
                .collect(Collectors.toList());
    }

}

package com.eleinad.gym.api;

import com.eleinad.gym.model.Author;
import com.eleinad.gym.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorAPI {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    @ResponseBody
    public List<Author> getAuthors() {
        return authorService.findAll();
    }
}

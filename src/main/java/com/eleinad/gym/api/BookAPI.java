package com.eleinad.gym.api;

import com.eleinad.gym.model.Book;
import com.eleinad.gym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookAPI {

    private final BookService bookService;

    @Autowired
    public BookAPI(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ResponseBody
    public List<Book> findAll() {
        return bookService.findAll();
    }
}

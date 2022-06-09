package com.eleinad.gym.api;

import com.eleinad.gym.model.BookDTO;
import com.eleinad.gym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDTO bookDTO) {
        bookService.createBook(bookDTO);
    }
}

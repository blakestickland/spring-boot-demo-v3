package io.nology.iceland.controllers;

import io.nology.iceland.payloads.books.BookCreate;
import io.nology.iceland.services.BookService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/test")
    public String test() {
        return "hello, world!";
    }

    @GetMapping(value = "/test/{name}")
    public String testName(@PathVariable String name) {
        return "hello, " + name + "!";
    }

    @GetMapping(value = "/test/{name}/{age}")
    public String testNameAge(@PathVariable String name, @PathVariable Integer age) {
        return String.format("hello, %s! You are %d years old, aren't you?", name, age);
    }

    // Creating books --> POST @PostMapping
    @PostMapping
    public void save(@Valid @RequestBody BookCreate book) {
        this.bookService.create(book);
    }
}

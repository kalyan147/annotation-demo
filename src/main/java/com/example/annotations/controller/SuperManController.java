package com.example.annotations.controller;

import com.example.annotations.annotation.ComicBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComicBook(year = "1938")
@RestController
@RequestMapping("/superman")
public class SuperManController implements BasicController {

    @GetMapping
    public String getMessage() {
        return "Up, up and away!";
    }
}

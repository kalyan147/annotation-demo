package com.example.annotations.controller;

import com.example.annotations.annotation.ComicBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComicBook(year = "1940")
@RestController
@RequestMapping("/flash")
public class FlashController implements BasicController {

    @GetMapping
    public String getMessage() {
        return "Fast as lightning!";
    }

}

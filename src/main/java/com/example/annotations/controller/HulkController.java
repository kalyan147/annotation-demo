package com.example.annotations.controller;

import com.example.annotations.annotation.ComicBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComicBook(year = "1962")
@RestController
@RequestMapping("/hulk")
public class HulkController implements BasicController {

    @GetMapping
    public String getMessage() {
        return "Hulk smash!!";
    }

}

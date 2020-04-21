package com.example.annotations.controller;

import com.example.annotations.annotation.Simpsons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Simpsons(gender = Simpsons.Gender.MALE)
@RestController
@RequestMapping("/homer")
public class HomerController implements BasicController {

    @GetMapping
    public String getMessage() {
        return "D'oh!";
    }
}

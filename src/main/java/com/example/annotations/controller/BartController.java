package com.example.annotations.controller;

import com.example.annotations.annotation.Simpsons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Simpsons(gender = Simpsons.Gender.MALE)
@RestController
@RequestMapping("/bart")
public class BartController implements BasicController {

    @GetMapping
    public String getMessage() {
        return "Don't have a cow, man!";
    }

}

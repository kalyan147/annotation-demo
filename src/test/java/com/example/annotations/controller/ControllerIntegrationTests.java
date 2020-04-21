package com.example.annotations.controller;

import com.example.annotations.annotation.ComicBook;
import com.example.annotations.annotation.Simpsons;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ControllerIntegrationTests {


    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private BasicController[] controllers;

    @BeforeAll
    public void initialization() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    void supermanTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/superman")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Up, up and away!"));
    }

    @Test
    void flashTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/flash")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Fast as lightning!"));
    }

    @Test
    void hulkTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/hulk")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hulk smash!!"));
    }

    @Test
    void bartTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/bart")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Don't have a cow, man!"));
    }

    @Test
    void homerTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/homer")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("D'oh!"));
    }

    @Test
    void lisaTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/lisa")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Bart!"));
    }

    @Test
    void comicBookTest() throws Exception {

        Map<String, Object> classes = context.getBeansWithAnnotation(ComicBook.class);

        for (String key : classes.keySet()) {

            BasicController controller = (BasicController) classes.get(key);

            if (controller.getClass().isAnnotationPresent(ComicBook.class)) {

                // get a reference to the annotation
                ComicBook annotation = controller.getClass().getAnnotation(ComicBook.class);

                // Test the annotation element
                String year = annotation.year();
                assert (!"".equals(year));
            }
        }
    }

    @Test
    void simpsonTest() throws Exception {

        Map<String, Object> classes = context.getBeansWithAnnotation(Simpsons.class);

        for (String key : classes.keySet()) {

            BasicController controller = (BasicController) classes.get(key);

            // get a reference to the annotation
            Simpsons annotation = controller.getClass().getAnnotation(Simpsons.class);

            // Test the annotation element
            Simpsons.Gender gender = annotation.gender();
            assert (gender != Simpsons.Gender.NONE);

        }
    }

}

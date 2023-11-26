package com.ysun60.moviemeta.subpackages.controller;

import com.ysun60.moviemeta.subpackages.repository.MovieRepo;
import com.ysun60.moviemeta.subpackages.entity.Movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {


    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieRepo movieRepo;


    @Test
    void findMovieByTitle() throws Exception {
        when(movieRepo.findMovieDataBytitleContainingIgnoreCase(anyString())).thenReturn(Collections.singletonList(new Movie()));

        mockMvc.perform(get("/search?title=TestTitle"))
                .andExpect(status().isOk());
    }

    @BeforeEach
    public void setup() {
        //System.out.println("movieService = " + movieRepo);
    }
}
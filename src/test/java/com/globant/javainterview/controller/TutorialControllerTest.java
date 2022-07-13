package com.globant.javainterview.controller;

import com.globant.javainterview.model.Tutorial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TutorialControllerTest {
    public static final String HTTP_LOCALHOST = "http://localhost:";
    @LocalServerPort
    private int port;
    private TutorialController tutorialController;
    private TestRestTemplate restTemplate;

    TutorialControllerTest(TutorialController tutorialController, TestRestTemplate restTemplate) {
        this.tutorialController = tutorialController;
        this.restTemplate = restTemplate;
    }

    @Test
    void index() {
        assertThat(tutorialController).isNotNull();
    }

    @Test
    public void getAllTutorials() {
        ResponseEntity<List<Tutorial>> responseEntity = restTemplate.exchange(
                HTTP_LOCALHOST + port + "/api/tutorials",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                }
        );
        List<Tutorial> tutorials = responseEntity.getBody();

        assertNotNull(tutorials);
        assertThat(tutorials).hasSize(3);
        assertThat(tutorials.get(0)).isNotNull();
        assertThat(tutorials.get(0)).isInstanceOf(Tutorial.class);
        assertThat(tutorials.get(0).getTitle()).isEqualTo("Java");
    }
}
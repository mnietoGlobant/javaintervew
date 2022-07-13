package com.globant.javainterview.service;

import com.globant.javainterview.model.Tutorial;
import com.globant.javainterview.repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public List<Tutorial> getAllTutorials() {
        return new ArrayList<>(tutorialRepository.findAll());
    }
}

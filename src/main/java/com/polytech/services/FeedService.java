package com.polytech.services;

import com.polytech.persistence.StoryRepository;

import java.util.List;

public class FeedService {

    private StoryRepository storyRepository;

    //Constructeur
    public FeedService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    //Service fetchAll
    public List<Story> fetchAll() {
        return storyRepository.findAll();
    }
}

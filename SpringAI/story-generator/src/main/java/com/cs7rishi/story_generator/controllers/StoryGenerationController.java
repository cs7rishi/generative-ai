package com.cs7rishi.story_generator.controllers;

import com.cs7rishi.story_generator.services.StoryGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class StoryGenerationController {

    @Autowired
    private StoryGenerationService storyGenerationService;

    @PostMapping("/create")
    private Flux<String> generateStory(@RequestBody String prompt){
        return storyGenerationService.generateStory(prompt);
    }
}

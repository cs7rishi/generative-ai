package com.cs7rishi.story_generator.services;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryGenerationService {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    public String generateStory(String promptText){
        Prompt prompt = new Prompt(promptText);
        return openAiChatModel.call(prompt).getResults().get(0).getOutput().getContent();
    }
}

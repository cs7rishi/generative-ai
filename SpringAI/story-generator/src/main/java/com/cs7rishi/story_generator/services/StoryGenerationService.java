package com.cs7rishi.story_generator.services;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StoryGenerationService {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    public Flux<String> generateStory(String promptText) {
        OpenAiChatOptions options = OpenAiChatOptions.builder().maxTokens(100).build();

        Prompt prompt = new Prompt(promptText,options);
        return openAiChatModel.stream(prompt).map(this::extractText);
    }
    private String extractText(ChatResponse chatResponse){
        return chatResponse.getResult().getOutput().getContent();
    }
}

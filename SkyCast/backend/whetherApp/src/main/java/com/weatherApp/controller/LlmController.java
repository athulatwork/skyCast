package com.weatherApp.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weatherApp.model.ChatRequest;
import com.weatherApp.service.LLMService;

@RequestMapping("/ask")
@RestController
public  class LlmController{
    
    private final LLMService llmService;

    public LlmController(LLMService llmService) {
        this.llmService = llmService;
    }

    @PostMapping
public String chat(@RequestBody ChatRequest request) {
    return llmService.askLLM(request.getMessage());
}
}

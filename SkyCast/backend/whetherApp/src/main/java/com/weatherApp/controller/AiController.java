package com.weatherApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weatherApp.service.AiService;

@RestController
@RequestMapping("/ai")
public class AiController {
    
    private final AiService aiService;
    public AiController(AiService aiService ){
    this.aiService = aiService; 

}
@GetMapping("/ask")
public String ask ( @RequestParam String qustion){
    return aiService.ask(qustion );

}
}
